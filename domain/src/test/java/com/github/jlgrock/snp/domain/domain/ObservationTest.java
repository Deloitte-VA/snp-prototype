package com.github.jlgrock.snp.domain.domain;

import com.github.jlgrock.snp.domain.types.Observation;
import com.github.jlgrock.snp.domain.types.primitives.IntegerPrimitive;
import com.github.jlgrock.snp.domain.types.primitives.StringPrimitive;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.time.Instant;

import static org.testng.Assert.assertEquals;

public class ObservationTest {
    /**
     * public function returns void
     */
	@Test
	public void test() {
		
		StringPrimitive st1 = Mockito.mock (StringPrimitive.class);
		IntegerPrimitive it1 = Mockito.mock (IntegerPrimitive.class);
		String st2 = new String(); 
		Instant dt1 = Instant.now();
		String st3 = new String();
		String st4 = new String();
		
		Observation observation1 = new Observation();
		
		observation1.setName(st1);
		observation1.setValue(it1);
		observation1.setApplies(st2);
		observation1.setIssued(dt1);
		observation1.setIdentifier(st3);
		observation1.setSubject(st4);	
		
		assertEquals(st1, observation1.getName());
		assertEquals(it1, observation1.getValue());
		assertEquals(st2, observation1.getApplies());
		assertEquals(dt1, observation1.getIssued());
		assertEquals(st3, observation1.getIdentifier());
		assertEquals(st4, observation1.getSubject());
		
	}

}

