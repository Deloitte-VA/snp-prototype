package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CarePlan;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class CarePlanProcessor extends AbstractFhirProcessor {

    @Inject
    public CarePlanProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        CarePlan carePlan = (CarePlan) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return CarePlan.class;
    }

}
