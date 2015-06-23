package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Coding;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FhirCodingGraphBuilder extends AbstractFhirLogicGraphBuilder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FhirCodingGraphBuilder.class);

    private final Coding coding;

    @Override
    public LogicGraph build() {
        Connector connector = processCoding(coding);
        LogicalExpressionBuilder.SufficientSet(connector);
        return (LogicGraph) getLogicalExpressionBuilder().build();
    }

    public FhirCodingGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final Coding codingIn) {
        super(logicGraphClassifierIn);
        coding = codingIn;
    }

    protected Connector processCoding(final Coding coding) {
        throw new UnsupportedOperationException();
    }
}
