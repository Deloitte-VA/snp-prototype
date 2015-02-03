package com.deloitte.mongo.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PCETest {

	@Test
	public void test() {
		
	    Long ln1 = new Long(201521);
	    String st1 = "Touchdown";
	    
		Long ln2 = new Long(201522);
	    String st2 = "Field Goal";
	    
		PCE pc1 = new PCE();
		PCE pc2 = new PCE();
		
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

		assertEquals(pc1.toString(), "PCE{id=201521, desc='Touchdown'}");
		assertNotEquals(pc1.hashCode(), pc2.hashCode());
		
	}
	
}
