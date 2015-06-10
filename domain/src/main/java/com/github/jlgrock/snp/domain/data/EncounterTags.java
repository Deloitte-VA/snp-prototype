package com.github.jlgrock.snp.domain.data;

/**
 * JSON key tags related to Encounter serialization.
 */
public final class EncounterTags {

    /**
     * The patient id.
     */
    public static final String FHIR_ID = "fhir_id";

    /**
     * The date of the encounter.
     */
    public static final String PATIENT_CLASS = "patient_class";

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
     * The list of observations.
     */
    public static final String OBSERVATIONS_TAG = "observations";

    /**
     * Private constructor for utility class.
     */
    private EncounterTags(){
    }
  
}

