package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Device;

/**
 *
 */
public class DeviceProcessor extends AbstractFhirProcessor {

    private final Device device;

    public DeviceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Device deviceIn) {
        super(logicGraphClassifierIn);
        device = deviceIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
