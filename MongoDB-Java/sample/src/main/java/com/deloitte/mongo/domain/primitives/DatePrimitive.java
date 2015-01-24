package com.deloitte.mongo.domain.primitives;

/**
 *
 */
public class DatePrimitive extends AbstractSimplePrimitive {
    @Override
    public PrimitiveType determineType() {
        return PrimitiveType.DATE;
    }
}
