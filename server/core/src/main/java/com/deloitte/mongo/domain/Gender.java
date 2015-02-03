package com.deloitte.mongo.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum Gender {
    MALE(1), FEMALE(2), OTHER(3);

    private static Map<Integer, Gender> valuesById;

    static {
        valuesById = new HashMap<>();
        Arrays.asList(Gender.values()).forEach(gender -> valuesById.put(gender.getId(), gender));
    }

    private final Integer id;

    private Gender(final Integer i) {
        id = i;
    }

    public Integer getId() {
        return id;
    }

    public static Gender getValueById(final Integer id) {
        return valuesById.get(id);
    }
}
