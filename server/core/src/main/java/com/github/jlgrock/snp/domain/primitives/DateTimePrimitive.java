package com.github.jlgrock.snp.domain.primitives;

import org.joda.time.DateTime;

/**
 * The primitive representing Date + Time values.  The underlying type is the JodaTime DateTime object.
 */
class DateTimePrimitive extends AbstractSimplePrimitive<DateTime> {

    /**
     * @param value The value to store.
     */
    DateTimePrimitive(final DateTime value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DATETIME;
    }
}

