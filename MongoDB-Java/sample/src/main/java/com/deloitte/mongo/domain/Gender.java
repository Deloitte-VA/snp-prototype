package com.deloitte.mongo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jlgrock on 1/11/15.
 */
public enum Gender {
    MALE(1), FEMALE(2), OTHER(3);

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    static {
        values = new HashMap<Integer, Gender>() {{
            values().forEach((Gender gender) -> put(gender.getId(), gender));
        }};
    }

    static Map<Integer, Gender> values;

    Integer id;

    Gender(Integer i) {
        id = i;
    }

    public Integer getId() {
        return id;
    }

    public static Map<Integer, Gender> getValues() {
        return values;
    }

    public static Gender getValueById(Integer id) {
        return getValues().get(id);
    }
}
