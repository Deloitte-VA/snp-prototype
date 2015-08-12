package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.converters.FhirPatientConverter;
import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * The processor used for handling Patient objects unmarshalled from FHIR XML.
 */
@Service
public class PatientProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientProcessor.class);

    private final FhirPatientConverter fhirPatientConverter;
    private final PatientRepository patientRepository;

    @Inject
    public PatientProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                            final FhirPatientConverter fhirPatientConverterIn,
                            final PatientRepository patientRepositoryIn) {
        super(logicalExpressionClassifierIn);
        fhirPatientConverter = fhirPatientConverterIn;
        patientRepository = patientRepositoryIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Patient patient = (Patient) unmarshalledObject;
        LOGGER.trace("Processing Patient {}", patient);

        com.github.jlgrock.snp.domain.types.Patient patientInDB = patientRepository.findOneByFhirId(identifier);

        // convert the patient to a domain type
        com.github.jlgrock.snp.domain.types.Patient patientOut = fhirPatientConverter.convert(patient);
        if (patientInDB != null) {
            patientOut.setId(patientInDB.getId());
        }

        // set the fhir id that was passed in
        patientOut.setFhirId(identifier);

        // insert/update the patient in the db
        patientRepository.save(patientOut);
	}

    @Override
    public Class processesType() {
        return Patient.class;
    }
}
