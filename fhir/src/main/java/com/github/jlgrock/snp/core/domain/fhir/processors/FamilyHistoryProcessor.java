package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.FamilyHistory;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class FamilyHistoryProcessor extends AbstractFhirProcessor {

    @Inject
    public FamilyHistoryProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        FamilyHistory familyHistory = (FamilyHistory) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return FamilyHistory.class;
    }
}
