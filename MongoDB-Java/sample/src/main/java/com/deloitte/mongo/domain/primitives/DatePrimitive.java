package com.deloitte.mongo.domain.primitives;

import org.joda.time.LocalDate;

/**
 *
 */
public class DatePrimitive extends AbstractSimplePrimitive<LocalDate> {

    DatePrimitive(final Object valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DATE;
    }
}
