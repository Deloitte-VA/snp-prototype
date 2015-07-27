package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Binary;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class BinaryProcessor extends AbstractFhirProcessor {

    @Inject
    public BinaryProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Binary binary = (Binary) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Binary.class;
    }

}
