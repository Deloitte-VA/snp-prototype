package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Observation;
import org.jvnet.hk2.annotations.Service;

/**
 *
 */
@Service
public interface ObservationRepository {
    /**
     * Find the unique Encounter by Encounter Fhir Id and Observation Fhir Id
     * @param encounterFhirId the unique identifier used in fhir
     * @param observationFhirId the unique identifier used in fhir
     * @return the patient matching the id
     */
    Observation findObservationByFhirId(String encounterFhirId, String observationFhirId);
}
