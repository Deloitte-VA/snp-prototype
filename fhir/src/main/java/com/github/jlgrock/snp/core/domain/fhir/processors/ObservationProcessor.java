package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Observation;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ObservationProcessor extends AbstractFhirProcessor {

    @Inject
    public ObservationProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Observation observation = (Observation) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Observation.class;
    }
}
