package com.github.jlgrock.snp.domain.types.primitives;

import org.bson.types.Binary;

/**
 * The primitive representing Binary values.  The underlying type is the MongoDB Binary object.
 */
public class BinaryPrimitive extends AbstractSimplePrimitive<Binary> {

    /**
     * @param value The value to store
     */
    BinaryPrimitive(final Binary value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.BINARY64;
    }
}

