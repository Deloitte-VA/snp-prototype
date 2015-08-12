package com.github.jlgrock.snp.domain.domain;

import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class ClassifiedPceTest {
    /**
     * public function returns void
     */
    @Test
    public void test() {

        Integer ln1 = 6;
        String st1 = "Touchdown";

        Integer ln2 = 7;
        String st2 = "Field Goal";

        ClassifiedPce pc1 = new ClassifiedPce();
        ClassifiedPce pc2 = new ClassifiedPce();

        pc1.setId(ln1);
        pc1.setDesc(st1);

        assertEquals(ln1, pc1.getId());
        assertEquals(st1, pc1.getDesc());

        pc2.setId(ln1);
        pc2.setDesc(st1);

        assertTrue(pc2.equals(pc1));

        pc2.setId(ln2);
        pc2.setDesc(st2);

        assertFalse(pc2.equals(pc1));

        assertNotEquals(pc1.getId(), pc2.getId());
        assertNotEquals(pc1.getDesc(), pc2.getDesc());

        assertEquals("ClassifiedPce{id=" + ln1 + ", nid=null, desc=" + st1 + "}", pc1.toString());
        assertNotEquals(pc1.hashCode(), pc2.hashCode());

    }

}

