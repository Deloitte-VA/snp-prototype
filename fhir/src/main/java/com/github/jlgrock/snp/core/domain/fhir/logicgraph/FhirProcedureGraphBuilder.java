package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
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
public class FhirProcedureGraphBuilder extends AbstractFhirLogicGraphBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FhirProcedureGraphBuilder.class);

    final Procedure procedure;

    @Override
    public LogicGraph build() {
        Connector connector = processProcedure(procedure);
        LogicalExpressionBuilder.SufficientSet(connector);
        return (LogicGraph) getLogicalExpressionBuilder().build();
    }

    public FhirProcedureGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final Procedure procedureIn) {
        super(logicGraphClassifierIn);
        procedure = procedureIn;
    }

    protected And processProcedure(final Procedure procedure) {
        //TODO this should be transferred to the Procedure processor
        LOGGER.trace("Creating Fhir Procedure Logic Graph");
        List<And> childrenNodes = new ArrayList<>();

        CodeableConcept typeCodeableConcept = procedure.getType();
        And typeNode = buildCodeableConcept(typeCodeableConcept);
        childrenNodes.add(typeNode);

        List<CodeableConcept> bodySiteList = procedure.getBodySite();
        for (CodeableConcept codeableConcept : bodySiteList) {
            childrenNodes.add(buildCodeableConcept(codeableConcept));
        }

        return LogicalExpressionBuilder.And(childrenNodes.toArray(new And[childrenNodes.size()]));
    }
}
