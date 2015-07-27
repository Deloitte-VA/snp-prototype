package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Organization;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class OrgazationProcessor extends AbstractFhirProcessor {

    @Inject
    public OrgazationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        OrgazationProcessor orgazationProcessor = (OrgazationProcessor) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Organization.class;
    }
}
