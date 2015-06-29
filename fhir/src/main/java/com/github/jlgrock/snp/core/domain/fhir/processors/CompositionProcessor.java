package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Composition;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class CompositionProcessor extends AbstractFhirProcessor {

    @Inject
    public CompositionProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Composition composition = (Composition) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Composition.class;
    }

}
