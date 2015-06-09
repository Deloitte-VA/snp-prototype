package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.AndNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
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

    private final LogicGraphClassifier logicGraphClassifier;

    public AbstractLegoLogicGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn) {
        logicGraphClassifier = logicGraphClassifierIn;
    }

	protected AbstractNode buildRelation(final Relation relation) {
        LOGGER.trace("Building from relation node...");
        // A relation can have a type and a destination
        Type type = relation.getType();
        LocalConcept typeConcept = buildType(type);

        Destination destination = relation.getDestination();
        AbstractNode destinationConcept = processDestination(destination);

		return SomeRole(typeConcept.getNid(), destinationConcept);
	}

    protected LocalConcept buildType(final Type type) {
        LOGGER.trace("Building from type node...");
        Concept typeConcept = type.getConcept();
        LocalConcept processedConcept = buildConcept(typeConcept);
        return processedConcept;
    }

    protected AbstractNode processDestination(final Destination destination) {
        LOGGER.trace("Building from destination node...");
        // A destination can contain an expression, text, boolean, or measurement

        Expression expression = destination.getExpression();
        if (expression != null) {
            return buildExpression(expression);
        } else {
            //TODO store this to MongoDB
            throw new UnsupportedOperationException();
        }
    }

    protected AbstractNode buildExpression(final Expression expression) {
        LOGGER.trace("Building from expression node...");
        //Can have either a Concept or a list of sub-Expressions, plus 0 or more Relations and 0 or more RelationGroups

        AbstractNode returnVal = null;

        List<AbstractNode> values = new ArrayList<>();

        Concept concept = expression.getConcept();

        String sourceSctId = null;
        if (concept.getSctid() != null) {
            sourceSctId = Long.toString(concept.getSctid());
        }

        //TODO what if I get a sctId?  Are we done?

        AbstractNode subConceptOrExpression = null;
        if (concept != null) {
            LocalConcept localConcept = buildConcept(concept);
            subConceptOrExpression = Concept(localConcept.getNid());
        } else {
            List<Expression> subExpressions = expression.getExpression();
            List<Node> expressionNodes = subExpressions.stream().map(this::buildExpression).collect(Collectors.toList());

            subConceptOrExpression = And(expressionNodes.toArray(new AbstractNode[expressionNodes.size()]));
        }
        values.add(subConceptOrExpression);

        List<Relation> relations = expression.getRelation();
        if (relations != null) {
            values.addAll(relations.stream().map(this::buildRelation).collect(Collectors.toList()));
        }

        List<RelationGroup> relationGroups = expression.getRelationGroup();
        if (relationGroups != null) {
            values.addAll(relationGroups.stream().map(this::buildRelationGroup).collect(Collectors.toList()));
        }

        if (values.size() == 1) {
            returnVal = subConceptOrExpression;
        } else {
            returnVal = And(values.toArray(new AbstractNode[values.size()]));
        }
        return returnVal;
	}

    protected LocalConcept buildConcept(final Concept concept) {
        LocalConcept returnVal;
        String description = concept.getDesc();

        // can only have a sctid or a uuid
        String sctId = Long.toString(concept.getSctid());
        if (sctId != null) {
            int nid = logicGraphClassifier.getNidFromSNOMED(sctId);
            returnVal = new LocalConcept(nid, description);
        } else {
            //TODO all of the examples have a sctid, but not sure what to do if we get a uuid
            throw new UnsupportedOperationException();
        }

        return returnVal;
    }

    protected AbstractNode buildRelationGroup(final RelationGroup relationGroup) {
        // can contain 1 or more Relations
        AndNode andNode = null;
        List<Relation> relations = relationGroup.getRelation();
        if (relations.size() > 0) {
            List<AbstractNode> nodes = relations.stream().map(this::buildRelation).collect(Collectors.toList());
            andNode = And(nodes.toArray(new AbstractNode[nodes.size()]));
        }
        return andNode;
    }

}
