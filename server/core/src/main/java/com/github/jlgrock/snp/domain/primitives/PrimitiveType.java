package com.github.jlgrock.snp.domain.primitives;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The primitive types allowable in the SNP Observation/PCE objects.
 *
 * Based off of the current FHIR primitives
 * http://www.hl7.org/implement/standards/fhir/datatypes.html
 */
public enum PrimitiveType {
    /**
     * The allowable Primitive Types.
     */
    BOOLEAN(1), INTEGER(2), DECIMAL(3), BINARY64(4), DATE(5), DATETIME(6), STRING(7);

    private static Map<Integer, PrimitiveType> valuesById;

    static {
        valuesById = new HashMap();
        Arrays.asList(PrimitiveType.values()).forEach(type -> valuesById.put(type.getId(), type));
    }

    private final Integer id;

    private PrimitiveType(Integer i) {
        id = i;
    }

    /**
     * @return the id of the Primitive Type
     */
    public Integer getId() {
        return id;
    }

    /**
     * Reverse-Lookup a PrimitiveType by its ID
     *
     * @param id the id of the PrimitiveType
     * @return the PrimitiveType referred
     */
    public static PrimitiveType getValueById(final Integer id) {
        return valuesById.get(id);
    }
}
