package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.core.domain.lego.Destination;
import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Relation;
import com.github.jlgrock.snp.core.domain.lego.RelationGroup;
import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;

/**
 * 
 * Abstract implementation of Logic Graph Builder
 *
 */
public abstract class AbstractLogicGraphBuilder extends LogicGraphBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLogicGraphBuilder.class);
	
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

    public AbstractLogicGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    /**
     * Get the native identifier
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    private int getNidFromSNOMED(final String sctid) {
        int nid = 0;
        UUID uuid = null;
        TerminologySnapshotDI terminologySnapshotDI = null;
        try {
            uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));
            terminologySnapshotDI = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());
        } catch (IOException ex) {
            LOGGER.error("Unable to get ViewCoordinates Inferred Latest", ex);
            //TODO determine what to do.  May need to refactor Campbells code if we are going to keep using this pattern
        }
        if (terminologySnapshotDI != null) {
            try {
                //Get NID from UUID
                nid = terminologySnapshotDI.getNidForUuids(uuid);
            } catch (IOException ex) {
                LOGGER.error("Unable to get Nid from UUID", ex);
            }
        }
        //TODO this shouldn't return a 0 in the case of an error
        return nid;
    }


    /**
	 * Parse the relationship
	 * @param relation Relation
	 * @param sourceConceptNid int
	 * @return Node
	 */
	public Node processRelation(final Relation relation, final int sourceConceptNid) {
        // A relation can have a type and a destination

		if(relation.getDestination() != null && relation.getDestination().getExpression() != null
				&& relation.getDestination().getExpression().getRelation() != null
				&& !relation.getDestination().getExpression().getRelation().isEmpty()) {
			for(Relation r : relation.getDestination().getExpression().getRelation()) {
				return processRelation(r, sourceConceptNid);
			}
		}

		long isAboutSctId = relation.getType().getConcept().getSctid();
		long destinationSctId = relation.getDestination().getExpression().getConcept().getSctid();

		//Get NID from UUID
		int typeConceptNid = getNidFromSNOMED(String.valueOf(isAboutSctId));
		int destinationNid = getNidFromSNOMED(String.valueOf(destinationSctId));

		//Create AndNode
		AndNode andNode = And();
		andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));
		return SufficientSet(andNode);
	}

	private void processExpression(final Expression expression) {
        //Can have either a Concept or an Expression subelement, plus 0 or more Relations and 0 or more RelationGroups

        // Determine if this Expression has been classified

        // Determine if it is SufficientSet or NecessarySet.  In most cases in Lego, this will be a SufficientSet because
        // all of the primitives have been defined in snomed.


	}

    private void processRelationGroup(final RelationGroup relationGroup) {
        // can contain 1 or more Relations
    }

    private void processDestination(final Destination destination) {
        // can contain an expression, text, a boolean, or a measurement.
        // Only process if this is an expression
        Expression expression = destination.getExpression();
        if (expression != null) {
            processExpression(expression);
        }
    }
}
