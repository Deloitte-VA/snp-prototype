package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;


@Service
public class AllergyIntoleranceProcessor extends AbstractFhirProcessor {

    @Inject
    public AllergyIntoleranceProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        AllergyIntolerance allergyIntolerance = (AllergyIntolerance) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return AllergyIntolerance.class;
    }

}
