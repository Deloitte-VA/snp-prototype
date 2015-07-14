package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Assertion;
import org.jvnet.hk2.annotations.Service;

/**
 *
 */
@Service
public interface AssertionRepository {
    /**
     * Find the unique Encounter by Encounter Fhir Id and Assertion Fhir Id
     * @param encounterFhirId the unique identifier used in fhir
     * @param assertionFhirId the unique identifier used in fhir
     * @return the patient matching the id
     */
    Assertion findAssertionByFhirId(String encounterFhirId, String assertionFhirId);
}
