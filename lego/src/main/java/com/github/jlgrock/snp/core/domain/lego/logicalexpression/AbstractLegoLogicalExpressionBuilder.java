package com.github.jlgrock.snp.core.domain.lego.logicalexpression;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Concept;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.core.domain.lego.model.Relation;
import com.github.jlgrock.snp.core.domain.lego.model.RelationGroup;
import com.github.jlgrock.snp.core.domain.lego.model.Type;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilderService;
import gov.vha.isaac.ochre.api.logic.assertions.ConceptAssertion;
import gov.vha.isaac.ochre.api.logic.assertions.SomeRole;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.And;
import org.ihtsdo.otf.tcc.api.spec.ConceptSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * 
 * Abstract implementation of Logic Graph Builder
 *
 */
public abstract class AbstractLegoLogicalExpressionBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLegoLogicalExpressionBuilder.class);

    private LogicalExpressionBuilder logicalExpressionBuilder;

    private final LogicalExpressionClassifier logicalExpressionClassifier;

    public AbstractLegoLogicalExpressionBuilder(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        logicalExpressionClassifier = logicalExpressionClassifierIn;
        LogicalExpressionBuilderService expressionBuilderService = LookupService.getService(LogicalExpressionBuilderService.class);
        logicalExpressionBuilder = expressionBuilderService.getLogicalExpressionBuilder();
    }

    /**
     * @return get the current logical expression builder, to turn it into a logic expression/graph
     */
    protected LogicalExpressionBuilder getLogicalExpressionBuilder() {
        return logicalExpressionBuilder;
    }

    /**
     * Can have either a Concept or a list of sub-Expressions, plus 0 or more Relations and 0 or more RelationGroups
     *
     * @param expression the expression to parse
     * @return the AND of all of the concept/subextpression + relations + relationGroups
     */
    protected And buildExpression(final Expression expression) {
        LOGGER.trace("Building from expression node...");

        List<gov.vha.isaac.ochre.api.logic.assertions.Assertion> values = new ArrayList<>();

        // Concept or a list of sub-Expressions
        Concept concept = expression.getConcept();
        And subConceptOrExpression = null;
        if (concept != null) {
            subConceptOrExpression = LogicalExpressionBuilder.And(LogicalExpressionBuilder.ConceptAssertion(buildConcept(concept), getLogicalExpressionBuilder()));
        } else {
            List<Expression> subExpressions = expression.getExpression();
            List<gov.vha.isaac.ochre.api.logic.assertions.Assertion> expressionNodes = subExpressions.stream()
                    .map(this::buildExpression)
                    .collect(Collectors.toList());

            subConceptOrExpression = LogicalExpressionBuilder.And(expressionNodes.toArray(new And[expressionNodes.size()]));
        }
        values.add(subConceptOrExpression);

        // parse 0 or more Relation XML objects
        List<Relation> relations = expression.getRelation();
        if (relations != null) {
            values.addAll(relations.stream()
                    .map(this::buildRelation)
                    .collect(Collectors.toList()));
        }

        // parse 0 or more Relation Group XML objects
        List<RelationGroup> relationGroups = expression.getRelationGroup();
        if (relationGroups != null) {
            values.addAll(relationGroups.stream()
                    .map(this::buildRelationGroup)
                    .collect(Collectors.toList()));
        }

        // And them all together
        return LogicalExpressionBuilder.And(values.toArray(new gov.vha.isaac.ochre.api.logic.assertions.Assertion[values.size()]));
    }

    /**
     * A relation can have a type (which contains one single concept) and a destination
     *
     * @param relation the relation to parse
     * @return
     */
	protected SomeRole buildRelation(final Relation relation) {
        LOGGER.trace("Building from relation node...");

        Type type = relation.getType();
        ConceptSpec typeConcept = buildType(type);

        Destination destination = relation.getDestination();
        And destinationAssertion = processDestination(destination);

        ConceptAssertion destinationConcept = (ConceptAssertion) destinationAssertion;

		return LogicalExpressionBuilder.SomeRole(typeConcept, destinationConcept);
	}

    /**
     * Type can only take a concept.  Since this is only used in Relations (currently), this returns a ConceptSpec.
     * @param type
     * @return
     */
    protected ConceptSpec buildType(final Type type) {
        LOGGER.trace("Building from type node...");
        Concept concept = type.getConcept();
        return buildConcept(concept);
    }

    /**
     * A destination can contain an expression, text, boolean, or measurement
     *
     * @param destination the destination to parse
     * @return
     */
    protected And processDestination(final Destination destination) {
        LOGGER.trace("Building from destination node...");

        //TODO this skips the storage of the measurement.  Not sure if this is correct...
        Expression expression = destination.getExpression();
        if (expression != null) {
            return buildExpression(expression);
        } else {
            //TODO store this to MongoDB
            throw new UnsupportedOperationException();
        }
    }

    /**
     * A Concept can have a uuid, an sctid, and a description.  These will be turned into the corresponding Conceptspec
     * @param concept the concept to parse
     * @return the new ConceptSpec
     */
    protected ConceptSpec buildConcept(final Concept concept) {
        LOGGER.trace("Building from concept node...");
        String description = concept.getDesc();
        String uuidString = concept.getUuid();

        UUID uuid;
        if (uuidString == null) {
            Long typeSctId = concept.getSctid();
            uuid = logicalExpressionClassifier.getUUIDFromSNOMED(Long.toString(typeSctId));
        } else {
            uuid = UUID.fromString(uuidString);
        }

        LOGGER.trace("node with description '{}' built", description);
        return new ConceptSpec(description, uuid);
    }

    /**
     * can contain 1 or more Relations
     *
     * @param relationGroup the relation group to parse
     * @return
     */
    protected And buildRelationGroup(final RelationGroup relationGroup) {

        And andNode = null;
        List<Relation> relations = relationGroup.getRelation();
        if (relations.size() > 0) {
            List<SomeRole> nodes = relations.stream()
                    .map(this::buildRelation)
                    .collect(Collectors.toList());
            andNode = LogicalExpressionBuilder.And(nodes.toArray(new SomeRole[nodes.size()]));
        }
        return andNode;
    }

    public abstract LogicalExpression build(final Expression expression);

}
