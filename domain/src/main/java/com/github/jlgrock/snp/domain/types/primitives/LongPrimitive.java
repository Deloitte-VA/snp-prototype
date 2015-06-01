package com.github.jlgrock.snp.domain.types.primitives;

/**
 * The primitive representing Integer values.  The underlying type is the Long object (to cover the case that this is a very large integer).
 */
public class LongPrimitive extends AbstractSimplePrimitive<Long> {

    /**
     * @param valueIn The value to store.
     */
    LongPrimitive(final Long valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.LONG;
    }
}
