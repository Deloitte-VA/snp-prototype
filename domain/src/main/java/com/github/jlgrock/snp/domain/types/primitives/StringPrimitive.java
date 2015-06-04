package com.github.jlgrock.snp.domain.types.primitives;

/**
 * The primitive representing String values.  The underlying type is the String object.
 */
public class StringPrimitive extends AbstractSimplePrimitive<String> {

    /**
     * @param valueIn the represented String.
     */
    StringPrimitive(final String valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.STRING;
    }
}

