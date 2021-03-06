package com.github.jlgrock.snp.domain.data;

/**
 * JSON key tags related to Encounter serialization.
 */
public final class EncounterTags {

    /**
     * The date of the encounter.
     */
    public static final String ENCOUNTER_CLASS = "class";

    /**
     * The subject, stored as a string.
     */
    public static final String SUBJECT = "subject";

    /**
     * The status, stored as a string.
     */
    public static final String STATUS = "status";

    /**
     * The participant, stored as a string description.
     */
    public static final String PARTICIPANT = "participant";

    /**
     * The participant, stored as a string description.
     */
    public static final String PATIENT_ID = "patient_id";

    /**
     * The list of assertions.
     */
    public static final String ASSERTIONS_TAG = "assertions";

    /**
     * The FHIR ID.
     */
    public static final String FHIR_ID = "fhirId";


    /**
     * Private constructor for utility class.
     */
    private EncounterTags(){
    }
  
}

