package com.github.jlgrock.snp.core.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class RaceTest {

	@Test
	public void test() {
	
		Race race1 = Race.CAUCASIAN;
		Race race2 = Race.ASIAN;
		Race race3 = Race.HISPANIC;
		Race race4 = Race.BLACK_AFRICAN_AMERICAN;
		Race race5 = Race.AMERICAN_INDIAN;
		Race race6 = Race.OTHER;
		
		Race race7 = Race.getValueById(1);
		Race race8 = Race.getValueById(2);
		Race race9 = Race.getValueById(3);
		Race race10 = Race.getValueById(4);
		Race race11 = Race.getValueById(5);
		Race race12 = Race.getValueById(6);
		
		assertEquals(Race.CAUCASIAN, race1);
		assertEquals(Race.ASIAN, race2);
		assertEquals(Race.HISPANIC, race3);
		assertEquals(Race.BLACK_AFRICAN_AMERICAN, race4);
		assertEquals(Race.AMERICAN_INDIAN, race5);
		assertEquals(Race.OTHER, race6);
		
		assertEquals(new Integer(1), race1.getId());
		assertEquals(new Integer(2), race2.getId());
		assertEquals(new Integer(3), race3.getId());
		assertEquals(new Integer(4), race4.getId());
		assertEquals(new Integer(5), race5.getId());
		assertEquals(new Integer(6), race6.getId());
		
		assertEquals(Race.CAUCASIAN, race7);
		assertEquals(Race.ASIAN, race8);
		assertEquals(Race.HISPANIC, race9);	
		assertEquals(Race.BLACK_AFRICAN_AMERICAN, race10);
		assertEquals(Race.AMERICAN_INDIAN, race11);
		assertEquals(Race.OTHER, race12);	
		
	}

}
