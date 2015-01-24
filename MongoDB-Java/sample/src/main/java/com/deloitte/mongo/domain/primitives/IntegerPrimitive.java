package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class IntegerPrimitive extends AbstractSimplePrimitive<Long> {

    IntegerPrimitive(final Object valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.INTEGER;
    }
}
