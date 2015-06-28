package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.converters.FhirEncounterConverter;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Service
public class EncounterProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncounterProcessor.class);

    private final EncounterRepository encounterRepository;
    private final FhirEncounterConverter fhirEncounterConverter;
    private final PatientRepository patientRepository;

    @Inject
    public EncounterProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                              final FhirEncounterConverter fhirEncounterConverterIn,
                              final EncounterRepository encounterRepositoryIn,
                              final PatientRepository patientRepositoryIn) {
        super(logicGraphClassifierIn);
        fhirEncounterConverter = fhirEncounterConverterIn;
        encounterRepository = encounterRepositoryIn;
        patientRepository = patientRepositoryIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Encounter encounter = (Encounter) unmarshalledObject;

        LOGGER.trace("Processing Encounter {}", encounter);

        // convert the encounter to the domain type of encounter
        com.github.jlgrock.snp.domain.types.Encounter saveVal = fhirEncounterConverter.convert(encounter);

        // Copy the observations over if they exist already
        com.github.jlgrock.snp.domain.types.Encounter foundEncounter = encounterRepository.findOneByFhirId(identifier);
        if (foundEncounter != null) {
            saveVal.setObservations(foundEncounter.getObservations());
        }

        // insert/update the encounter
        encounterRepository.save(saveVal);

        // pull out the fhirId
        String reference = encounter.getSubject().getReference().getValue();
        String fhirId = parseFhirId(reference);

        // find the patient by the fhir id
        com.github.jlgrock.snp.domain.types.Patient patient = patientRepository.findOneByFhirId(fhirId);

        // save the patient if it doesn't exists
        if (patient == null) {
            patient = new com.github.jlgrock.snp.domain.types.Patient();
            patientRepository.save(patient);
        }
	}

    @Override
    public Class processesType() {
        return Encounter.class;
    }
}
