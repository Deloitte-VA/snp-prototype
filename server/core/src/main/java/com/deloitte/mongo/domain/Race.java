package com.deloitte.mongo.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum Race {
    CAUCASIAN(1), ASIAN(2), HISPANIC(3), BLACK_AFRICAN_AMERICAN(4), AMERICAN_INDIAN(5), OTHER(6);

    static Map<Integer, Race> valuesById;

    static {
        valuesById = new HashMap<>();
        Arrays.asList(Race.values()).forEach(race -> valuesById.put(race.getId(), race));
    }

    private final Integer id;

    private Race(final Integer i) {
        id = i;
    }

    public Integer getId() {
        return id;
    }

    public static Race getValueById(Integer id) {
        return valuesById.get(id);
    }
}
