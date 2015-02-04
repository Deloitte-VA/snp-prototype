package com.github.jlgrock.snp.domain.primitives;

/**
 * The primitive representing Boolean values.  The underlying type is the Boolean object.
 */
public class BooleanPrimitive extends AbstractSimplePrimitive<Boolean> {

    /**
     * @param value The value to store.
     */
    BooleanPrimitive(final Boolean value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.BOOLEAN;
    }
}
