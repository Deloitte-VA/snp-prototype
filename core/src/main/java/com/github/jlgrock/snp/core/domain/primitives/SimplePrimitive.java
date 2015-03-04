package com.github.jlgrock.snp.core.domain.primitives;

import org.bson.types.Binary;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

/**
 * The interface that defines all of the primitive classes allowable by the SNP server.
 */
public interface SimplePrimitive {

    /**
     * A string builder to build up a string for exceptions parsing SimplePrimitives
     *
     * @param parsedType the type that it is marked as
     * @param expectedClassType the expected class type
     * @param o the object that is being analyzed
     * @return the string for the exception
     */
    static String makeErrorMessage(PrimitiveType parsedType, String expectedClassType, Object o) {
        StringBuilder sb = new StringBuilder();
        sb.append("ENUM indicated is ");
        sb.append(parsedType.name());
        sb.append(", but value is of type ");
        sb.append(o.getClass().getName());
        sb.append(" which is not the expected type (");
        sb.append(expectedClassType);
        sb.append(")");
        return sb.toString();
    }

    /**
     * Returns the value object.  This should be one of the values supported by SimplePrimitives.
     *
     * @return the value.
     */
    Object getValue();

    /**
     * Get the PrimitiveType so you know what kind of object to parse into.
     *
     * @return the specific type, so that it can be stored with the object in MongoDB.
     */
    PrimitiveType getType();

    /**
     * A factory class that will create the primitive using a type and value object.
     *
     * The Object itself is not enough to be able to determine the typing.  For example, the storage
     * of a Long value could indicate a DATE, DATETIME, or INTEGER primitive type.
     *
     * @param type the index of the type, which should correspond to the PrimitiveType id.
     * @param value the value object, which could be of a number of different type.
     * @return the primitive that was created using the type and value
     *
     * throws java.lang.IllegalArgumentException if the object type does not match the type
     */
    static SimplePrimitive createPrimitive(Integer type, Object value) {
        SimplePrimitive sp = null;
        PrimitiveType parsedType = PrimitiveType.getValueById(type);
        if (parsedType == null) {
            throw new IllegalArgumentException("Type not recognized.  Type=" + type.toString());
        }

        switch(parsedType) {
            case BOOLEAN:
                if (!(value instanceof Boolean)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.BOOLEAN, "Boolean", value));
                }
                sp = new BooleanPrimitive((Boolean) value);
                break;
            case BINARY64:
                if (!(value instanceof Binary)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.BINARY64, "Binary", value));
                }
                sp = new BinaryPrimitive((Binary) value);
                break;
            case DATE:
                if (!(value instanceof Long)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.LONG, "Long", value));
                }
                sp = new DatePrimitive(new LocalDate((Long) value));
                break;
            case DATETIME:
                if (!(value instanceof Long)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.LONG, "Long", value));
                }
                sp = new DateTimePrimitive(new DateTime((Long) value));
                break;
            case DECIMAL:
                if (!(value instanceof BigDecimal)) {
                throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.DECIMAL, "Decimal", value));
                }
                sp = new DecimalPrimitive((BigDecimal) value);
                break;
            case INTEGER:
                if (!(value instanceof Integer)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.INTEGER, "Integer", value));
                }
                sp = new IntegerPrimitive((Integer) value);
                break;
            case LONG:
                if (!(value instanceof Long)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.LONG, "Long", value));
                }
                sp = new LongPrimitive((Long) value);
                break;
            case STRING:
                if (!(value instanceof String)) {
                    throw new IllegalArgumentException(SimplePrimitive.makeErrorMessage(PrimitiveType.BOOLEAN, "String", value));
                }
                sp = new StringPrimitive((String) value);
                break;
            default:
                //Can't ever get to this
        }
        return sp;
    }
}

