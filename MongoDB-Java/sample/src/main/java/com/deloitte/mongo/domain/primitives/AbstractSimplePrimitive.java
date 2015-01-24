package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public abstract class AbstractSimplePrimitive {
    public abstract PrimitiveType determineType();

    public static SimplePrimitive factory() {
        return null;// TODO
    }
}
