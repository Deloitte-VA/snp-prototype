package com.deloitte.mongo.domain.primitives;

import org.bson.types.Binary;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimitivesTest {
    @Test
    public void testGoodBinary() {
        byte[] bytes = {1, 0, 0 ,1, 1, 1, 1, 1};
        Binary binary = new Binary(bytes);
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.BINARY64.getId(), binary);
        assertTrue(simplePrimitive instanceof BinaryPrimitive);
        assertEquals(PrimitiveType.BINARY64, simplePrimitive.getType());
        assertEquals(binary, simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadBinary() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.BINARY64.getId(), str);
    }

    @Test
    public void testGoodBoolean() {
        Boolean booleanTest = false;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.BOOLEAN.getId(), booleanTest);
        assertTrue(simplePrimitive instanceof BooleanPrimitive);
        assertEquals(PrimitiveType.BOOLEAN, simplePrimitive.getType());
        assertEquals(booleanTest, simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadBoolean() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.BOOLEAN.getId(), str);
    }

    @Test
    public void testGoodDate() {
        Long longVal = 1234l;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.DATE.getId(), longVal);
        assertTrue(simplePrimitive instanceof DatePrimitive);
        assertEquals(PrimitiveType.DATE, simplePrimitive.getType());
        assertEquals(new LocalDate(longVal), simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadDate() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.DATE.getId(), str);
    }

    @Test
    public void testGoodDateTime() {
        Long longVal = 1234l;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.DATETIME.getId(), longVal);
        assertTrue(simplePrimitive instanceof DateTimePrimitive);
        assertEquals(PrimitiveType.DATETIME, simplePrimitive.getType());
        assertEquals(new DateTime(longVal), simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadDateTime() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.DATETIME.getId(), str);
    }

    @Test
    public void testGoodDecimal() {
        BigDecimal bigDecimal = new BigDecimal("2.2");
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.DECIMAL.getId(), bigDecimal);
        assertTrue(simplePrimitive instanceof DecimalPrimitive);
        assertEquals(PrimitiveType.DECIMAL, simplePrimitive.getType());
        assertEquals(bigDecimal, simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadDecimal() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.DECIMAL.getId(), str);
    }

    @Test
    public void testGoodInteger() {
        Long integer = 5l;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.INTEGER.getId(), integer);
        assertTrue(simplePrimitive instanceof IntegerPrimitive);
        assertEquals(PrimitiveType.INTEGER, simplePrimitive.getType());
        assertEquals(integer, simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadInteger() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.INTEGER.getId(), str);
    }

    @Test
    public void testGoodString() {
        String str = "bla";
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.STRING.getId(), str);
        assertTrue(simplePrimitive instanceof StringPrimitive);
        assertEquals(PrimitiveType.STRING, simplePrimitive.getType());
        assertEquals(str, simplePrimitive.getValue());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadString() {
        Integer integer = 6;
        SimplePrimitive.createPrimitive(PrimitiveType.STRING.getId(), integer);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testUnknownType() {
        Double floatTest = 4.0;
        SimplePrimitive.createPrimitive(103, floatTest);
    }


}