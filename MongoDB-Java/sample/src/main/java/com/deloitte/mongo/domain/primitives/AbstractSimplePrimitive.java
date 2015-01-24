package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public abstract class AbstractSimplePrimitive<T> implements SimplePrimitive {
    Object value;

    AbstractSimplePrimitive(final Object valueIn) {
        value = valueIn;
    }

    @Override
    public abstract PrimitiveType getType();

    @Override
    public T getValue() {
       return (T) value;
    };
}
