package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class BinaryPrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.BINARY64;
    }
}
