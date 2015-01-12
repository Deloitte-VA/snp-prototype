package com.deloitte.mongo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jlgrock on 1/11/15.
 */
public enum Race {
    CAUCASIAN(1), ASIAN(2), HISPANIC(3), BLACK_AFRICAN_AMERICAN(4), AMERICAN_INDIAN(5), OTHER(6);

    static {
        values = new HashMap<Integer, Race>() {{
            values().forEach((Race race) -> put(race.getId(), race));
        }};
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    static final Map<Integer, Race> values;

    Integer id;

    Race(Integer i) {
        id = i;
    }

    public Integer getId() {
        return id;
    }

    public static Map<Integer, Race> getValues() {
        return values;
    }

    public static Race getValueById(Integer id) {
        return getValues().get(id);
    }
}
