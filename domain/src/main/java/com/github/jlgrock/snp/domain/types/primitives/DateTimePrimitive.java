package com.github.jlgrock.snp.domain.types.primitives;

import java.time.Instant;

/**
 * The primitive representing Date + Time values.  The underlying type is the Java 8 Instant object.
 */
public class DateTimePrimitive extends AbstractSimplePrimitive<Instant> {

    /**
     * @param value The value to store.
     */
    DateTimePrimitive(final Instant value) {
        super(value);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DATETIME;
    }
}

