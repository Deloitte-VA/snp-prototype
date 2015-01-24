package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class IntegerPrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.INTEGER;
    }
}
