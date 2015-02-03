package com.deloitte.mongo.domain;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

public class PatientTest {

	@Test
	public void test() {

	    Long ln1 = new Long(222015);
	    String st1 = "Brady";
	    String st2 = "Wilson";
	    String st3 = "Lynch";
		Date dt1 = Mockito.mock (Date.class); 
		Gender gn1 = Gender.MALE; 
		Race rc1 = Race.CAUCASIAN; 
	    
	    Long ln2 = new Long(212015);
	    String st4 = "Gronkowski";
	    String st5 = "Amendola";
	    String st6 = "Sherman";
		Date dt2 = Mockito.mock (Date.class); 
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
		
		assertEquals(pt1.toString(), "Patient{id=222015, firstName='Brady', middleName='Wilson', lastName='Lynch', dob=Mock for Date, hashCode: 1223685984, gender=MALE, race=CAUCASIAN}");
		assertNotEquals(pt1.hashCode(), pt2.hashCode());
		
	}
;
}
