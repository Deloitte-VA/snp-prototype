package com.github.jlgrock.snp.domain.types.primitives;

import java.time.LocalDate;

/**
 * The primitive representing Date values.  The underlying type is the JodaTime LocalDate object.
 */
public class DatePrimitive extends AbstractSimplePrimitive<LocalDate> {

    /**
     * @param valueIn The value to store.
     */
    DatePrimitive(final LocalDate valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DATE;
    }
}

