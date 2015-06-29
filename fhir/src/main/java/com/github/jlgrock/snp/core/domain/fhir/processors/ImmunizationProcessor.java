package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Immunization;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ImmunizationProcessor extends AbstractFhirProcessor {

    @Inject
    public ImmunizationProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Immunization immunization = (Immunization) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Immunization.class;
    }
}
