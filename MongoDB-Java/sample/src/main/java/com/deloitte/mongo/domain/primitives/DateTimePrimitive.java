package com.deloitte.mongo.domain.primitives;

import org.joda.time.DateTime;

/**
 *
 */
class DateTimePrimitive extends AbstractSimplePrimitive<DateTime> {

    DateTimePrimitive(final Object value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DATETIME;
    }
}
