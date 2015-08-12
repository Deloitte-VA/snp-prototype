package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.SecurityEvent;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * The processor used for handling SecurityEvent objects unmarshalled from FHIR XML.
 */
@Service
public class SecurityEventProcessor extends AbstractFhirProcessor {

    @Inject
    public SecurityEventProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        SecurityEvent securityEvent = (SecurityEvent) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return SecurityEvent.class;
    }
}
