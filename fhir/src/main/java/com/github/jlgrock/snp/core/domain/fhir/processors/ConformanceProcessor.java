package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Conformance;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ConformanceProcessor extends AbstractFhirProcessor {

    @Inject
    public ConformanceProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Conformance conformance = (Conformance) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Conformance.class;
    }

}
