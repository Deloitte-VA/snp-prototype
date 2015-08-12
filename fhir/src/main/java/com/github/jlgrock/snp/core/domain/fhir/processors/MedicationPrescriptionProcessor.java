package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationPrescription;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class MedicationPrescriptionProcessor extends AbstractFhirProcessor {

    @Inject
    public MedicationPrescriptionProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        MedicationPrescription medicationPrescription = (MedicationPrescription) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return MedicationPrescription.class;
    }
}
