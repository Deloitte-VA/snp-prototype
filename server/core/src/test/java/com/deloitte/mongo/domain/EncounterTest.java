package com.deloitte.mongo.domain;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class EncounterTest {

	@Test
	public void test() {
				
	    Long ln1 = new Long(222015);		
		Patient pt1 = Mockito.mock (Patient.class);
		Date dt1 = Mockito.mock (Date.class);
		Integer it1 = 212015;
	    String st1 = "Sprained Ankle";
	    List lt1 = Mockito.mock (List.class);	
	    
	    Long ln2 = new Long(212015);		
		Patient pt2 = Mockito.mock (Patient.class);
		Date dt2 = Mockito.mock (Date.class);
		Integer it2 = 222015;
	    String st2 = "Sprained Wrist";
	    List lt2 = Mockito.mock (List.class);	
	    
	    Encounter en1 = new Encounter();
	    
        en1.setDate(dt1);
	    en1.setReasonForVisit(st1);
	    en1.setObservations(lt1);
	    en1.setType(it1);
	    en1.setId(ln1);
        en1.setPatient(pt1);

	    Encounter en2 = new Encounter();
	    
        en2.setDate(dt1);
	    en2.setReasonForVisit(st1);
	    en2.setObservations(lt1);
	    en2.setType(it1);
	    en2.setId(ln1);
        en2.setPatient(pt1);
        
		assertTrue(en2.equals(en1));
        
		assertEquals(dt1, en1.getDate());
		assertEquals(st1, en1.getReasonForVisit());
		assertEquals(lt1, en1.getObservations());
		assertEquals(it1, en1.getType());
		assertEquals(ln1, en1.getId());
		assertEquals(pt1, en1.getPatient());
		
        en2.setDate(dt2);
	    en2.setReasonForVisit(st2);
	    en2.setObservations(lt2);
	    en2.setType(it2);
	    en2.setId(ln2);
        en2.setPatient(pt2);
		
		assertFalse(en2.equals(pt1));
		
		assertNotEquals(en1.getDate(), en2.getDate());
		assertNotEquals(en1.getReasonForVisit(), en2.getReasonForVisit());
		assertNotEquals(en1.getObservations(), en2.getObservations());
		assertNotEquals(en1.getType(), en2.getType());
		assertNotEquals(en1.getId(), en2.getId());
		assertNotEquals(en1.getPatient(), en2.getPatient());
		
		assertEquals(pt1.toString(), "Encounter [id=222015, patient=Mock for Patient, hashCode: 1635546341, date=Mock for Date, hashCode: 1698156408, type=212015, reasonForVisit=Sprained Ankle, observations=Mock for List, hashCode: 1740035246]");
		assertNotEquals(en1.hashCode(), en2.hashCode());
		
	}

}
