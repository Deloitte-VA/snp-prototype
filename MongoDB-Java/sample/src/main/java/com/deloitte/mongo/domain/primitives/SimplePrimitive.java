package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public interface SimplePrimitive {
    public Object getValue();

    public PrimitiveType determineType();

}
