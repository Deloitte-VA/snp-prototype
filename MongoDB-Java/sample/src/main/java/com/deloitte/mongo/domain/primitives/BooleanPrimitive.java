package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class BooleanPrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.BOOLEAN;
    }
}
