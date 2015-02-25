package com.github.jlgrock.snp.core.domain;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
/**
 * 
 * @author vbhole
 *
 */
public class EncounterTest {
    /**
     * public function returns void
     */
	@Test
	public void test() {
				
	    Long ln1 = new Long(201521);		
		Patient pt1 = Mockito.mock (Patient.class);
		DateTime dt1 = new DateTime(2015, 2, 2, 0, 0, 0, DateTimeZone.UTC);
		Integer it1 = 201523;
	    String st1 = "Sprained Ankle";
	    List lt1 = Mockito.mock (List.class);	
	    
	    Long ln2 = new Long(201524);		
		Patient pt2 = Mockito.mock (Patient.class);
		DateTime dt2 = new DateTime(2015, 2, 5, 0, 0, 0, DateTimeZone.UTC);
		Integer it2 = 201526;
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
		
		assertEquals(en1.toString(), "Encounter{id=201521, date=2015-02-02T00:00:00.000Z, reasonForVisit='Sprained Ankle'}");
		assertNotEquals(en1.hashCode(), en2.hashCode());

	}

}

