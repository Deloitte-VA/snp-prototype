package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.core.domain.lego.Concept;
import com.github.jlgrock.snp.core.domain.lego.Destination;
import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Relation;
import com.github.jlgrock.snp.core.domain.lego.RelationGroup;
import com.github.jlgrock.snp.core.domain.lego.Type;
import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 
 * Abstract implementation of Logic Graph Builder
 *
 */
public abstract class AbstractLegoLogicGraphBuilder extends LogicGraphBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLegoLogicGraphBuilder.class);

    private class LocalConcept {
        private int nid;
        private String description;

        public LocalConcept(final int nidIn, final String descriptionIn) {
            nid = nidIn;
            description = descriptionIn;
        }

        public int getNid() {
            return nid;
        }

        public String getDescription() {
            return description;
        }
    }

//	/**
//	 * Get the native identifier
//	 * @param sctid SNOMED clinical terms identifier
//	 * @return native identifier
//	 */
//	public int getNidFromSNOMED(final String sctid) {
//    	int nid = 0;
//    	try {
//    		TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
//    		TerminologySnapshotDI termSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());
//    		UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));
//
//    		//Get NID from UUID
//    		nid = termSnapshot.getNidForUuids(uuid);
//    	} catch (IOException ex) {
//    		LOGGER.error("Fatal error occured", ex);
//    	}
//    	return nid;
//    }
//
//	/**
//	 * Start the expression service
//	 */
//    public static void startExpressionService() {
//    	if(LookupService.getRunLevelController().getCurrentRunLevel() != 2) {
//			System.setProperty(Constants.CHRONICLE_COLLECTIONS_ROOT_LOCATION_PROPERTY, "target/data/object-chronicles");
//    		System.setProperty(Constants.SEARCH_ROOT_LOCATION_PROPERTY, "target/data/search");
//
//    		LookupService.getRunLevelController().proceedTo(2);
//    		LOGGER.info("System up...");
//		} else {
//			LOGGER.info("System already up and running!");
//		}
//    }
//
//    /**
//     * Stop the expression service
//     */
//    public static void stopExpressionService() {
//    	LookupService.getRunLevelController().proceedTo(-1);
//	    LOGGER.info("System down...");
//    }

    private final TerminologyStoreDI terminologyStoreDI;

    public AbstractLegoLogicGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    /**
     * Get the native identifier
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    protected ConceptChronicleBI findChronicle(final String sctid) {
        ConceptChronicleBI returnVal = null;
        TerminologySnapshotDI terminologySnapshotDI = null;
        try {
            TerminologySnapshotDI statedTermSnapshot = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
            TerminologySnapshotDI inferredTermSnapshot = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

            UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));
            terminologySnapshotDI = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

            returnVal = terminologyStoreDI.getConcept(uuid);
        } catch (IOException ex) {
            LOGGER.error("Unable to get ViewCoordinates Inferred Latest", ex);
            //TODO determine what to do.  May need to refactor Campbells code if we are going to keep using this pattern
        }
        return returnVal;
    }

    /**
	 * Get the native identifier
	 * @param sctid SNOMED clinical terms identifier
	 * @return native identifier
	 */
	public int getNidFromSNOMED(final String sctid) {
    	int nid = 0;
    	try {
    		TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
    		TerminologySnapshotDI termSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());
    		UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));

    		//Get NID from UUID
    		nid = termSnapshot.getNidForUuids(uuid);
    	} catch (IOException ex) {
    		LOGGER.error("Fatal error occured", ex);
    	}
    	return nid;
    }

	protected AbstractNode processRelation(final Relation relation) {
        // A relation can have a type and a destination
        Type type = relation.getType();
        LocalConcept typeConcept = processType(type);

        Destination destination = relation.getDestination();
        AbstractNode destinationConcept = processDestination(destination);

		return SomeRole(typeConcept.getNid(), destinationConcept);
	}

    protected LocalConcept processType(final Type type) {
        Concept typeConcept = type.getConcept();
        LocalConcept processedConcept = processConcept(typeConcept);
        return processedConcept;
    }

    protected AbstractNode processDestination(final Destination destination) {
        // A destination can contain an expression, text, boolean, or measurement

        Expression expression = destination.getExpression();
        if (expression != null) {
            return processExpression(expression);
        }
        //TODO needs work to handle text, boolean, or measurement
        throw new UnsupportedOperationException();
    }

    protected AbstractNode processExpression(final Expression expression) {
        //Can have either a Concept or a list of sub-Expressions, plus 0 or more Relations and 0 or more RelationGroups

        AbstractNode returnVal = null;

        List<AbstractNode> values = new ArrayList<>();

        Concept concept = expression.getConcept();

        Long sourceSctId = null;
        if (concept.getSctid() != null) {
            sourceSctId = concept.getSctid();
        }

        AbstractNode subConceptOrExpression = null;
        if (concept != null) {
            LocalConcept localConcept = processConcept(concept);
            subConceptOrExpression = Concept(localConcept.getNid());
        } else {
            List<Expression> subExpressions = expression.getExpression();
            List<Node> expressionNodes = subExpressions.stream().map(this::processExpression).collect(Collectors.toList());

            AndNode andNode = And();
            andNode.addChildren(expressionNodes.toArray(new Node[expressionNodes.size()]));
            subConceptOrExpression = andNode;
        }
        values.add(subConceptOrExpression);

        List<Relation> relations = expression.getRelation();
        if (relations != null) {
            values.addAll(relations.stream().map(this::processRelation).collect(Collectors.toList()));
        }

        List<RelationGroup> relationGroups = expression.getRelationGroup();
        if (relationGroups != null) {
            values.addAll(relationGroups.stream().map(this::processRelationGroup).collect(Collectors.toList()));
        }

        if (values.size() == 1) {
            returnVal = subConceptOrExpression;
        } else {
            returnVal = And(values.toArray(new AbstractNode[values.size()]));
        }
        return returnVal;
	}

    protected LocalConcept processConcept(final Concept concept) {
        LocalConcept returnVal;
        String description = concept.getDesc();

        // can only have a sctid or a uuid
        String sctId = Long.toString(concept.getSctid());
        if (sctId != null) {
            int nid = getNidFromSNOMED(sctId);
            returnVal = new LocalConcept(nid, description);
        } else {
            //TODO all of the examples have a sctid, but not sure what to do if we get a uuid
            throw new UnsupportedOperationException();
        }

        return returnVal;
    }

    protected AbstractNode processRelationGroup(final RelationGroup relationGroup) {
        // can contain 1 or more Relations
        AndNode andNode = null;
        List<Relation> relations = relationGroup.getRelation();
        if (relations.size() > 0) {
            List<AbstractNode> nodes = relations.stream().map(this::processRelation).collect(Collectors.toList());
            andNode = And(nodes.toArray(new AbstractNode[nodes.size()]));
        }
        return andNode;
    }

}
