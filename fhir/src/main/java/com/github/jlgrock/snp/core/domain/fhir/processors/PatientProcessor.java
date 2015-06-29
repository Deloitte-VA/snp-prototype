package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.converters.FhirPatientConverter;
import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Service
public class PatientProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientProcessor.class);

    private final FhirPatientConverter fhirPatientConverter;
    private final PatientRepository patientRepo;

    @Inject
    public PatientProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                            final FhirPatientConverter fhirPatientConverterIn,
                            final PatientRepository patientRepositoryIn) {
        super(logicGraphClassifierIn);
        fhirPatientConverter = fhirPatientConverterIn;
        patientRepo = patientRepositoryIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Patient patient = (Patient) unmarshalledObject;
        LOGGER.trace("Processing Patient {}", patient);

        // convert the patient to a domain type
        com.github.jlgrock.snp.domain.types.Patient patientOut = fhirPatientConverter.convert(patient);

        // set the fhir id that was passed in
        patientOut.setFhirId(identifier);

        // insert/update the patient in the db
		patientRepo.save(patientOut);
	}

    @Override
    public Class processesType() {
        return Patient.class;
    }
}
