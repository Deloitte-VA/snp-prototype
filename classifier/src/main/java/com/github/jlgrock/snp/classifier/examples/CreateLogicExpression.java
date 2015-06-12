package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilderService;
import org.ihtsdo.otf.tcc.api.metadata.binding.Snomed;

import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.And;
import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.ConceptAssertion;
import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.SomeRole;
import static gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder.SufficientSet;

/**
 *
 */
public class CreateLogicExpression {

    protected LogicGraph execute() {
        LogicalExpressionBuilderService expressionBuilderService = LookupService.getService(LogicalExpressionBuilderService.class);
        LogicalExpressionBuilder defBuilder = expressionBuilderService.getLogicalExpressionBuilder();

        SufficientSet(And(ConceptAssertion(Snomed.BLEEDING_FINDING, defBuilder),
                SomeRole(Snomed.FINDING_SITE, ConceptAssertion(Snomed.ABDOMINAL_WALL_STRUCTURE, defBuilder))));

        LogicalExpression abdominalWallBleedingDef = defBuilder.build();

        System.out.println("Created definition:\n\n " + abdominalWallBleedingDef);
        return (LogicGraph) abdominalWallBleedingDef; //apparently we can just assume this is a LogicGraph?
    }

    public static void main(String[] args) {
        CreateLogicExpression createLogicExpression = new CreateLogicExpression();
        createLogicExpression.execute();
    }
}
