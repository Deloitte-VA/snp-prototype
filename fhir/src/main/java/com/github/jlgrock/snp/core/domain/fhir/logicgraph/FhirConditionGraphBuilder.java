package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.And;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FhirConditionGraphBuilder extends AbstractFhirLogicGraphBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FhirProcedureGraphBuilder.class);

    final Condition condition;

    private static final String IS_ABOUT_SCTID = "53";
    private static final String HAS_LOCATION_SCTID = "57";

    @Override
    public LogicGraph build() {
        Connector connector = processCondition(condition);
        LogicalExpressionBuilder.SufficientSet(connector);
        return (LogicGraph) getLogicalExpressionBuilder().build();
    }

    public FhirConditionGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final Condition conditionIn) {
        super(logicGraphClassifierIn);
        condition = conditionIn;
    }

    protected And processCondition(final Condition condition) {
        LOGGER.trace("Creating Fhir Condition Logic Graph");
        List<And> childrenList = new ArrayList<>();

        //TODO so many other possible fields to look into.  just using two currently

        // Get the source
        CodeableConcept sourceCode = condition.getCode();
        And sourceNode = buildCodeableConcept(sourceCode);
        childrenList.add(sourceNode);

        return LogicalExpressionBuilder.And(childrenList.toArray(new And[childrenList.size()]));
    }

}
