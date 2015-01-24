package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class DecimalPrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.DECIMAL;
    }
}
