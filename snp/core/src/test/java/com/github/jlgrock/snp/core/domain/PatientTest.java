package com.github.jlgrock.snp.core.domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientTest {
    /**
     * public function returns void
     */
	@Test
	public void test() {

	    Long ln1 = new Long(201521l);
	    String st1 = "Brady";
	    String st2 = "Wilson";
	    String st3 = "Lynch";
		DateTime dt1 = new DateTime(2015, 2, 2, 0, 0, 0, DateTimeZone.UTC);
		Gender gn1 = Gender.MALE;
		Race rc1 = Race.CAUCASIAN;
	    
	    Long ln2 = new Long(201523l);
	    String st4 = "Gronkowski";
	    String st5 = "Amendola";
	    String st6 = "Sherman";
		DateTime dt2 = new DateTime(2015, 2, 4, 0, 0, 0, DateTimeZone.UTC);
		Gender gn2 = Gender.FEMALE; 
		Race rc2 = Race.ASIAN; 
		
		Patient pt1 = new Patient();
		
		pt1.setId(ln1);
		pt1.setFirstName(st1);
		pt1.setMiddleName(st2);
		pt1.setLastName(st3);
		pt1.setDateOfBirth(dt1);
		pt1.setGender(gn1);
		pt1.setRace(rc1);
		
		Patient pt2 = new Patient();
		
		pt2.setId(ln1);
		pt2.setFirstName(st1);
		pt2.setMiddleName(st2);
		pt2.setLastName(st3);
		pt2.setDateOfBirth(dt1);
		pt2.setGender(gn1);
		pt2.setRace(rc1);
		
		assertTrue(pt2.equals(pt1));
		
		assertEquals(ln1, pt1.getId());
		assertEquals(st1, pt1.getFirstName());
		assertEquals(st2, pt1.getMiddleName());
		assertEquals(st3, pt1.getLastName());
		assertEquals(dt1, pt1.getDateOfBirth());
		assertEquals(gn1, pt1.getGender());
		assertEquals(rc1, pt1.getRace());
	
		pt2.setId(ln2);
		pt2.setFirstName(st4);
		pt2.setMiddleName(st5);
		pt2.setLastName(st6);
		pt2.setDateOfBirth(dt2);
		pt2.setGender(gn2);
		pt2.setRace(rc2);
		
		assertFalse(pt2.equals(pt1));
		
		assertNotEquals(pt1.getId(), pt2.getId());
		assertNotEquals(pt1.getFirstName(), pt2.getFirstName());
		assertNotEquals(pt1.getMiddleName(), pt2.getMiddleName());
		assertNotEquals(pt1.getLastName(), pt2.getLastName());
		assertNotEquals(pt1.getDateOfBirth(), pt2.getDateOfBirth());
		assertNotEquals(pt1.getGender(), pt2.getGender());
		assertNotEquals(pt1.getRace(), pt2.getRace());
		
		assertEquals(pt1.toString(), "Patient{id=201521, firstName='Brady', middleName='Wilson', lastName='Lynch', dateOfBirth=2015-02-02T00:00:00.000Z, gender=MALE, race=CAUCASIAN}");
		assertNotEquals(pt1.hashCode(), pt2.hashCode());
		
	}
;
}

