package com.github.jlgrock.snp.domain;

import org.mockito.ArgumentMatcher;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class MapPropertiesMatcher<T> extends ArgumentMatcher<T> {
    T thisObject;

    public MapPropertiesMatcher(T thisObject) {
        this.thisObject = thisObject;
    }

    @Override
    public boolean matches(Object argument) {
        // make sure they are both iterables
        Map m;
        List l;
        if(!(thisObject instanceof Map)) {
            return false;
        }
        Map thisMap = (Map) thisObject;
        if(!(argument instanceof Map)) {
            return false;
        }
        Map thatMap = (Map) argument;
        return thisMap.entrySet().equals(thatMap.entrySet());
    }
}
