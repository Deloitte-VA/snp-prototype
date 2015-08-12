package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationAdministration;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * The processor used for handling MedicationAdministration objects unmarshalled from FHIR XML.
 */
@Service
public class MedicationAdministrationProcessor extends AbstractFhirProcessor {

    @Inject
    public MedicationAdministrationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        MedicationAdministration medicationAdministration = (MedicationAdministration) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return MedicationAdministration.class;
    }
}
