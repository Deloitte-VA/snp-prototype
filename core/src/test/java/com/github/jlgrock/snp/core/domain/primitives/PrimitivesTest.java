package com.github.jlgrock.snp.core.domain.primitives;

import org.bson.types.Binary;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PrimitivesTest {
	/**
	 * public function returns void
	 */
    @Test
    public void testGoodBinary() {
        byte[] bytes = {1, 0, 0 ,1, 1, 1, 1, 1};
        Binary binary = new Binary(bytes);
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.BINARY64.getId(), binary);
        assertTrue(simplePrimitive instanceof BinaryPrimitive);
        assertEquals(PrimitiveType.BINARY64, simplePrimitive.getType());
        assertEquals(binary, simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadBinary() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.BINARY64.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodBoolean() {
        Boolean booleanTest = false;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.BOOLEAN.getId(), booleanTest);
        assertTrue(simplePrimitive instanceof BooleanPrimitive);
        assertEquals(PrimitiveType.BOOLEAN, simplePrimitive.getType());
        assertEquals(booleanTest, simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadBoolean() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.BOOLEAN.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodDate() {
        Long longVal = LocalDate.now().toEpochDay();
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.DATE.getId(), longVal);
        assertTrue(simplePrimitive instanceof DatePrimitive);
        assertEquals(PrimitiveType.DATE, simplePrimitive.getType());
        assertEquals(LocalDate.ofEpochDay(longVal), simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadDate() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.DATE.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodDateTime() {
        Long longVal = 1234l;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.DATETIME.getId(), longVal);
        assertTrue(simplePrimitive instanceof DateTimePrimitive);
        assertEquals(PrimitiveType.DATETIME, simplePrimitive.getType());
        assertEquals(Instant.ofEpochMilli(longVal), simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadDateTime() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.DATETIME.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodDecimal() {
        BigDecimal bigDecimal = new BigDecimal("2.2");
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.DECIMAL.getId(), bigDecimal);
        assertTrue(simplePrimitive instanceof DecimalPrimitive);
        assertEquals(PrimitiveType.DECIMAL, simplePrimitive.getType());
        assertEquals(bigDecimal, simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadDecimal() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.DECIMAL.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodInteger() {
        Integer integer = 55;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.INTEGER.getId(), integer);
        assertTrue(simplePrimitive instanceof IntegerPrimitive);
        assertEquals(PrimitiveType.INTEGER, simplePrimitive.getType());
        assertEquals(integer, simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadInteger() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.INTEGER.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodLong() {
        Long lng = 55l;
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.LONG.getId(), lng);
        assertTrue(simplePrimitive instanceof LongPrimitive);
        assertEquals(PrimitiveType.LONG, simplePrimitive.getType());
        assertEquals(lng, simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadLong() {
        String str = "bla";
        SimplePrimitive.createPrimitive(PrimitiveType.LONG.getId(), str);
    }

    /**
     * public function returns void
     */
    @Test
    public void testGoodString() {
        String str = "bla";
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.STRING.getId(), str);
        assertTrue(simplePrimitive instanceof StringPrimitive);
        assertEquals(PrimitiveType.STRING, simplePrimitive.getType());
        assertEquals(str, simplePrimitive.getValue());
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testBadString() {
        Integer integer = 6;
        SimplePrimitive.createPrimitive(PrimitiveType.STRING.getId(), integer);
    }

    /**
     * public function returns void
     */
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void testUnknownType() {
        Double floatTest = 4.0;
        SimplePrimitive.createPrimitive(103, floatTest);
    }


}

