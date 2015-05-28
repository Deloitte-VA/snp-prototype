package com.github.jlgrock.snp.domain.data;

/**
 * JSON key tags related to Observation serialization.
 */
public class ObservationTags {
    /**
     * The identifier for an observation.
     */
    public static final String ID_TAG = "identifier";

    /**
     * The name of the observation.  This can stored as any primitive indicated in
     * the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String NAME_TAG = "name";

    /**
     * The enumerated type of primitive for an observation name.  This is based off
     * of the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String NAME_TYPE_TAG = "name_type";

    /**
     * The value of the observation.  This can stored as any primitive indicated in
     * the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String VALUE_TAG = "value";

    /**
     * The enumerated type of primitive for an observation value.  This is based off
     * of the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String VALUE_TYPE_TAG = "value_type";

    /**
     * General string about what this applies to.
     */
    public static final String APPLIES_TAG = "applies_tag";

    /**
     * General string about the issue.
     */
    public static final String ISSUED_TAG = "issued";

    /**
     * General string about what this subject to.
     */
    public static final String SUBJECT_TAG = "subject";

    /**
     * Private constructor for utility class.
     */
    private ObservationTags(){
    }
    
}

