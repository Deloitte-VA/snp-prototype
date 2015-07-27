package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;

/**
 *
 */
public abstract class AbstractFhirProcessor implements FhirElementProcessorService {

    private final LogicalExpressionClassifier logicalExpressionClassifier;

    protected AbstractFhirProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        logicalExpressionClassifier = logicalExpressionClassifierIn;
    }

    protected LogicalExpressionClassifier getLogicalExpressionClassifier() {
        return logicalExpressionClassifier;
    }

    @Override
    public abstract void process(final String identifier, final Object unmarshalledObject);

    protected String parseFhirId(String value) {
        return value.substring(value.indexOf('/'));
    }

    @Override
    public abstract Class processesType();

}
