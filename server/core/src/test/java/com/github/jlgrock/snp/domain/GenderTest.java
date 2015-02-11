package com.github.jlgrock.snp.domain;

import com.github.jlgrock.snp.domain.Gender;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenderTest {

	@Test
	public void test() {

		Gender gender1 = Gender.MALE;
		Gender gender2 = Gender.FEMALE;
		Gender gender3 = Gender.OTHER;
		
		Gender gender4 = Gender.getValueById(1);
		Gender gender5 = Gender.getValueById(2);
		Gender gender6 = Gender.getValueById(3);
		
		assertEquals(Gender.MALE, gender1);
		assertEquals(Gender.FEMALE, gender2);
		assertEquals(Gender.OTHER, gender3);	
		
		assertEquals(new Integer(1), gender1.getId());
		assertEquals(new Integer(2), gender2.getId());
		assertEquals(new Integer(3), gender3.getId());
		
		assertEquals(Gender.MALE, gender4);
		assertEquals(Gender.FEMALE, gender5);
		assertEquals(Gender.OTHER, gender6);	

	}

}

