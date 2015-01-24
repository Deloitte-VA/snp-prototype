package com.deloitte.mongo.domain.primitives;

import org.bson.types.Binary;

/**
 *
 */
public class BinaryPrimitive extends AbstractSimplePrimitive<Binary> {

    BinaryPrimitive(final Object value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.BINARY64;
    }
}
