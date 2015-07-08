package com.github.jlgrock.snp.domain.data;

/**
 * JSON key tags related to Assertion serialization.
 */
public class AssertionTags {

    /**
     * The observable of the assertion.  This can stored as any primitive indicated in
     * the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String OBSERVABLE_TAG = "observable";

    /**
     * The enumerated type of primitive for an assertion observable.  This is based off
     * of the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String OBSERVABLE_TYPE_TAG = "observable_type";

    /**
     * The value of the assertion.  This can stored as any primitive indicated in
     * the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String VALUE_TAG = "value";

    /**
     * The enumerated type of primitive for an assertion value.  This is based off
     * of the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String VALUE_TYPE_TAG = "value_type";
    
    /**
     * The provenance of the assertion. This can stored as any primitive indicated in
     * the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String PROVENANCE_TAG = "provenance";
    
    /**
     * The enumerated type of primitive for a assertion provenance. This is based off
     * of the {@link com.github.jlgrock.snp.domain.types.primitives} package
     */
    public static final String PROVENANCE_TYPE_TAG = "provenance_type";

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
    private AssertionTags(){
    }
    
}

