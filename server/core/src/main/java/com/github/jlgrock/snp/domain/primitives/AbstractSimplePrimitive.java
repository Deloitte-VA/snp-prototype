package com.github.jlgrock.snp.domain.primitives;

/**
 * The abstract SimplePrimitive.  It contains shared functionality between all
 * SimplePrimitive objects.
 */
public abstract class AbstractSimplePrimitive<T> implements SimplePrimitive {
    protected final Object value;

    /**
     * @param valueIn the value of the SimplePrimitive.
     */
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
