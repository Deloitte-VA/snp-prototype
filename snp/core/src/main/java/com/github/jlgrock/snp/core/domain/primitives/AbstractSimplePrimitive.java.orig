package com.github.jlgrock.snp.core.domain.primitives;

/**
 * The abstract SimplePrimitive.  It contains shared functionality between all
 * SimplePrimitive objects.
<<<<<<< HEAD
 * @param <T> The value type that will be stored in the primitive.
=======
 *
 * @param <T> The value type that will be stored in the primitive
>>>>>>> e1803de90dcd0b63428c30c86068504286310dea
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

