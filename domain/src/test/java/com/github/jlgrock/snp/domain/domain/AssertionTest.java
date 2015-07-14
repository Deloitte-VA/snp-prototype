package com.github.jlgrock.snp.domain.domain;

import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.primitives.IntegerPrimitive;
import com.github.jlgrock.snp.domain.types.primitives.StringPrimitive;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.time.Instant;

import static org.testng.Assert.assertEquals;

public class AssertionTest {
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
		
		Assertion assertion1 = new Assertion();
		
		assertion1.setObservable(st1);
		assertion1.setValue(it1);
		assertion1.setApplies(st2);
		assertion1.setIssued(dt1);
		assertion1.setIdentifier(st3);
		assertion1.setSubject(st4);	
		
		assertEquals(st1, assertion1.getObservable());
		assertEquals(it1, assertion1.getValue());
		assertEquals(st2, assertion1.getApplies());
		assertEquals(dt1, assertion1.getIssued());
		assertEquals(st3, assertion1.getIdentifier());
		assertEquals(st4, assertion1.getSubject());
		
	}

}

