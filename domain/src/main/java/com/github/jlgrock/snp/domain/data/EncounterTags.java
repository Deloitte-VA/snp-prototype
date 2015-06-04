package com.github.jlgrock.snp.domain.data;

/**
 * JSON key tags related to Encounter serialization.
 */
public final class EncounterTags {
    /**
     * The identifier.
     */
    public static final String ID_TAG = "_id";

    /**
     * The patient id.
     */
    public static final String PATIENT_TAG = "patient";

    /**
     * The date of the encounter.
     */
    public static final String DATE_TAG = "date";

    /**
     * The type of encounter, stored as an integer.
     */
    public static final String TYPE_TAG = "type";

    /**
     * The reason for the visit, stored as a string description.
     */
    public static final String REASON_FOR_VISIT_TAG = "reason_for_visit";

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

