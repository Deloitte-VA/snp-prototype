package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Practitioner;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class PractitionerProcessor extends AbstractFhirProcessor {

    @Inject
    public PractitionerProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Practitioner practitioner = (Practitioner) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Practitioner.class;
    }
}
