package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 *
 */
public class FhirCodeableConceptGraphBuilder extends AbstractFhirLogicGraphBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FhirCodeableConceptGraphBuilder.class);

    @Override
    public LogicGraph build(CodeableConcept codeableConcept) {
        LOGGER.trace("building Coding Graph Builder");
        LogicalExpressionBuilder.SufficientSet(buildCodeableConcept(codeableConcept));
        return (LogicGraph) getLogicalExpressionBuilder().build();
    }

    @Inject
    public FhirCodeableConceptGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

}
