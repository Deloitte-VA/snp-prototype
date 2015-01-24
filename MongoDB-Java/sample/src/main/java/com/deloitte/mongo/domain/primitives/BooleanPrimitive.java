package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class BooleanPrimitive extends AbstractSimplePrimitive<Boolean> {

    BooleanPrimitive(final Object value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.BOOLEAN;
    }
}
