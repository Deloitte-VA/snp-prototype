package com.github.jlgrock.snp.core.data;

/**
 * JSON key tags related to Patient serialization.
 */
public class PatientTags {
    /**
     * The unique identifier.
     */
    public static final String ID_TAG = "_id";

    /**
     * The first name of the patient.
     */
    public static final String FIRST_NAME_TAG = "first_name";

    /**
     * The middle name of the patient.
     */
    public static final String MIDDLE_NAME_TAG = "middle_name";

    /**
     * The last name of the patient.
     */
    public static final String LAST_NAME_TAG = "last_name";

    /**
     * The date of birth of the patient.
     */
    public static final String DATE_OF_BIRTH_TAG = "dob";

    /**
     * The integer value representation of the {@link com.github.jlgrock.snp.core.domain.Gender Gender}
     * class for a patient's gender.
     */
    public static final String GENDER_TAG = "gender";

    /**
     * The integer value representation of the {@link com.github.jlgrock.snp.core.domain.Race Race}
     * class for a patient's race.
     */
    public static final String RACE_TAG = "race";

    /**
     * Private constructor for utility class.
     */
    private PatientTags(){
    }
  
}

