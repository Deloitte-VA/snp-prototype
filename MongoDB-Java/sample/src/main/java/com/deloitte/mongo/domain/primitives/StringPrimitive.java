package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class StringPrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.STRING;
    }
}
