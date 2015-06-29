package com.github.jlgrock.snp.core.domain.fhir.converters;

import com.github.jlgrock.snp.apis.converters.Converter;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Service
public class FhirEncounterConverter
        implements Converter<com.github.jlgrock.snp.core.domain.fhir.model.Encounter, Encounter> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FhirEncounterConverter.class);

    private final PatientRepository patientRepository;

    @Inject
    public FhirEncounterConverter(final PatientRepository patientRepositoryIn) {
        patientRepository = patientRepositoryIn;
    }
	@Override
	public Encounter convert(
			com.github.jlgrock.snp.core.domain.fhir.model.Encounter source) {
		com.github.jlgrock.snp.domain.types.Encounter encounterOut = new com.github.jlgrock.snp.domain.types.Encounter();
		
		LOGGER.trace("convert xml encounter to model encounter: source={}", source);

        // lookup the patient id, if it exists.  If not, createa new patient with that Fhir Id.  We'll assume it's
        // uploaded at a later point
        String fhirId = source.getSubject().getReference().getValue().replaceFirst("Patient/", "");
        Patient patient = patientRepository.findOneByFhirId(fhirId);
        ObjectId patientId = null;
        if (patient != null) {
            patientId = patient.getId();
        } else {
            Patient newPatient = new Patient();
            newPatient.setFhirId(fhirId);
            patientRepository.save(newPatient);
        }
        encounterOut.setPatientId(patientId);

		encounterOut.setSubject(source.getSubject().getReference().getValue());
		encounterOut.setEncounterClass(source.getClazz().getValue().name());
		encounterOut.setStatus(source.getStatus().getValue().name());
		encounterOut.setParticipant(source.getParticipant().get(0).getIndividual().getReference().getValue());
		return encounterOut;
	}

}
