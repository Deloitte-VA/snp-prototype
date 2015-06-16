package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilderService;
import org.ihtsdo.otf.tcc.api.metadata.binding.Snomed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.And;
import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.ConceptAssertion;
import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.SomeRole;
import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.SufficientSet;

/**
 * How to create a Logic Expression/Logic Graph
 */
public class CreateLogicExpression {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateLogicExpression.class);

    /**
     * Execute the example
     * @return the logic graph created
     */
    protected LogicGraph execute() {
        LogicalExpressionBuilderService expressionBuilderService = LookupService.getService(LogicalExpressionBuilderService.class);
        LogicalExpressionBuilder defBuilder = expressionBuilderService.getLogicalExpressionBuilder();

        SufficientSet(And(ConceptAssertion(Snomed.BLEEDING_FINDING, defBuilder),
                SomeRole(Snomed.FINDING_SITE, ConceptAssertion(Snomed.ABDOMINAL_WALL_STRUCTURE, defBuilder))));

        LogicalExpression abdominalWallBleedingDef = defBuilder.build();

        LOGGER.info("Created definition:\n\n {}", abdominalWallBleedingDef);
        return (LogicGraph) abdominalWallBleedingDef; //apparently we can just assume this is a LogicGraph?
    }

    /**
     * Execute the Example
     *
     * @param args ignored
     */

    public static void main(final String[] args) {
        CreateLogicExpression createLogicExpression = new CreateLogicExpression();
        createLogicExpression.execute();
    }
}
