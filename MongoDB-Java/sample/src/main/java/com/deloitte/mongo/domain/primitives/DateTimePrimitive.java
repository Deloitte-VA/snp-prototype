package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class DateTimePrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.DATETIME;
    }
}
