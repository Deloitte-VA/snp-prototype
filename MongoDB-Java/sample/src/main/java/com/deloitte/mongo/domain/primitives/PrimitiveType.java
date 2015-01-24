package com.deloitte.mongo.domain.primitives;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum PrimitiveType {
    // Based off of the current FHIR primitives
    // http://www.hl7.org/implement/standards/fhir/datatypes.html
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

    public Integer getId() {
        return id;
    }

    public static PrimitiveType getValueById(final Integer id) {
        return valuesById.get(id);
    }
}
