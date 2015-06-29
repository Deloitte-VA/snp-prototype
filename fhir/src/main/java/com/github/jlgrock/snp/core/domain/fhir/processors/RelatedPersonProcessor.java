package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class RelatedPersonProcessor extends AbstractFhirProcessor {

    @Inject
    public RelatedPersonProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        RelatedPerson relatedPerson = (RelatedPerson) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return RelatedPerson.class;
    }
}
