package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ConceptMap;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ConceptMapProcessor extends AbstractFhirProcessor {

    @Inject
    public ConceptMapProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        ConceptMap conceptMap = (ConceptMap) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return ConceptMap.class;
    }

}
