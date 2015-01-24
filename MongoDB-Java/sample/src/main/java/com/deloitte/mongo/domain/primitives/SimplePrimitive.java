package com.deloitte.mongo.domain.primitives;

import org.bson.types.Binary;

import java.math.BigDecimal;

/**
 *
 */
public interface SimplePrimitive {
    public Object getValue();

    public PrimitiveType getType();

    public static SimplePrimitive createPrimitive(Integer type, Object value) {
        SimplePrimitive sp;
        switch(PrimitiveType.getValueById(type)) {
            case BOOLEAN:
                if (!(value instanceof Boolean)) {
                    throw new IllegalArgumentException("Type indicated is BOOLEAN, but value is not of the same type");
                }
                sp = new BooleanPrimitive(value);
                break;
            case BINARY64:
                if (!(value instanceof Binary)) {
                    throw new IllegalArgumentException("Type indicated is BINARY, but value is not of the same type");
                }
                sp = new BinaryPrimitive(value);
                break;
            case DATE:
                if (!(value instanceof Long)) {
                    throw new IllegalArgumentException("Type indicated is DATE, but value is not of the same type");
                }
                sp = new DatePrimitive(value);
                break;
            case DATETIME:
                if (!(value instanceof Long)) {
                    throw new IllegalArgumentException("Type indicated is DATETIME, but value is not of the same type");
                }
                sp = new DateTimePrimitive(value);
                break;
            case DECIMAL:
                if (!(value instanceof BigDecimal)) {
                throw new IllegalArgumentException("Type indicated is DECIMAL, but value is not of the same type");
                }
                sp = new DecimalPrimitive(value);
                break;
            case INTEGER:
                if (!(value instanceof Integer || value instanceof Long)) {
                    throw new IllegalArgumentException("Type indicated is INTEGER, but value is not of the same type");
                }
                sp = new IntegerPrimitive(value);
                break;
            case STRING:
                if (!(value instanceof String)) {
                    throw new IllegalArgumentException("Type indicated is STRING, but value is not of the same type");
                }
                sp = new StringPrimitive(value);
                break;
            default:
                throw new IllegalArgumentException("Type not recognized.  Type=" + type.toString());
        }
        return sp;
    }
}
