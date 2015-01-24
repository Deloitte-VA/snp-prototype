package com.deloitte.mongo.domain.primitives;

import java.math.BigDecimal;

/**
 *
 */
public class DecimalPrimitive extends AbstractSimplePrimitive<BigDecimal> {

    DecimalPrimitive(final Object valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DECIMAL;
    }
}
