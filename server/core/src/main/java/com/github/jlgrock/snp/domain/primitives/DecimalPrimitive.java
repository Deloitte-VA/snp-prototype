package com.github.jlgrock.snp.domain.primitives;

import java.math.BigDecimal;

/**
 * The primitive representing Decimal values.  The underlying type is the BigDecimal object.
 */
public class DecimalPrimitive extends AbstractSimplePrimitive<BigDecimal> {

    /**
     * @param valueIn the value to store
     */
    DecimalPrimitive(final BigDecimal valueIn) {
        super(valueIn);
    }

    @Override
    public PrimitiveType getType() {
        return PrimitiveType.DECIMAL;
    }
}
