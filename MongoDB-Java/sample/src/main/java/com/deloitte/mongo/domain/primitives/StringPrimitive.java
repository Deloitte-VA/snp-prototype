package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class StringPrimitive extends AbstractSimplePrimitive<String> {

    StringPrimitive(final Object valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.STRING;
    }
}
