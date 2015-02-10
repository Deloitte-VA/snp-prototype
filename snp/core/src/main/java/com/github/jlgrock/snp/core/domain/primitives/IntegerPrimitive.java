package com.github.jlgrock.snp.core.domain.primitives;

/**
 * The primitive representing Integer values.  The underlying type is the Long object (to cover the case that this is a very large integer).
 */
public class IntegerPrimitive extends AbstractSimplePrimitive<Long> {

    /**
     * @param valueIn The value to store.
     */
    IntegerPrimitive(final Long valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.INTEGER;
    }
}
