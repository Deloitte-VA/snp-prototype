package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FhirCodingGraphBuilder extends AbstractFhirLogicGraphBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FhirCodingGraphBuilder.class);

    private final CodeableConcept codeableConcept;

    @Override
    public LogicGraph build() {
        LOGGER.trace("building Coding Graph Builder");
        LogicalExpressionBuilder.SufficientSet(buildCodeableConcept(codeableConcept));
        return (LogicGraph) getLogicalExpressionBuilder().build();
    }

    public FhirCodingGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final CodeableConcept codeableConceptIn) {
        super(logicGraphClassifierIn);
        codeableConcept = codeableConceptIn;
    }

}
