package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ImagingStudy;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ImagingStudyProcessor extends AbstractFhirProcessor {

    @Inject
    public ImagingStudyProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        ImagingStudy imagingStudy = (ImagingStudy) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return ImagingStudy.class;
    }
}
