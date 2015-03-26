package com.github.jlgrock.snp.core.domain;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class PCETest {
    /**
     * public function returns void
     */
    @Test
    public void test() {

        String id1 = "123-456";
        String st1 = "Touchdown";

        String id2 = "789-012";
        String st2 = "Field Goal";

        PCE pc1 = new PCE();
        PCE pc2 = new PCE();

        pc1.setId(id1);
        pc1.setDesc(st1);

        assertEquals(id1, pc1.getId());
        assertEquals(st1, pc1.getDesc());

        pc2.setId(id1);
        pc2.setDesc(st1);

        assertTrue(pc2.equals(pc1));

        pc2.setId(id2);
        pc2.setDesc(st2);

        assertFalse(pc2.equals(pc1));

        assertNotEquals(pc1.getId(), pc2.getId());
        assertNotEquals(pc1.getDesc(), pc2.getDesc());

        assertEquals("PCE{id=201521, desc=Touchdown}", pc1.toString());
        assertNotEquals(pc1.hashCode(), pc2.hashCode());

    }

}

