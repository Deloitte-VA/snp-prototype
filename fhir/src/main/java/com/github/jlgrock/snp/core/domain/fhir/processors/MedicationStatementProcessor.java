package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationStatement;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class MedicationStatementProcessor extends AbstractFhirProcessor {

    @Inject
    public MedicationStatementProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        MedicationStatement medicationStatement = (MedicationStatement) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return MedicationStatement.class;
    }
}
