package com.github.jlgrock.snp.domain.domain;

import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class EncounterTest {
	
    private Long enc1Id = new Long(201521);
    private Long patient1Id = 123l;
    private String clazz1 = "OUTPATIENT";
    private String participant1 = "Practitioner/f201";
    private String status1 = "FINISHED";
    private String subject1 = "Patient/f203";
    
    private Long enc2Id = new Long(201731);
    private Long patient2Id = 345l;
    private String clazz2 = "INPATIENT";
    private String participant2 = "Practitioner/f301";
    private String status2 = "PLANNED";
    private String subject2 = "Patient/f201";

    private List<Observation> lt1 = new ArrayList<Observation>() {{
        Observation observation1 = new Observation();
        observation1.setIdentifier("abc");
        Observation observation2 = new Observation();
        observation1.setIdentifier("def");
        add(observation1);
        add(observation2);
    }};

	@Test
	public void testSettersAndGetters() {
				
	    Encounter en1 = new Encounter();
	    
	    en1.setObservations(lt1);
	    en1.setId(enc1Id);
        en1.setPatientId(patient1Id);
        en1.setEncounterClass(clazz1);
        en1.setParticipant(participant1);
        en1.setStatus(status1);
        en1.setSubject(subject1);
        
        assertEquals(en1.getId(), enc1Id);
        assertEquals(en1.getPatientId(), patient1Id);
        assertEquals(en1.getEncounterClass(), clazz1);
        assertEquals(en1.getParticipant(), participant1);
        assertEquals(en1.getStatus(), status1);
        assertEquals(en1.getSubject(), subject1);

	}
	
	@Test
	public void testEqualsAndEquals() {
	    Encounter en1 = new Encounter();
	    
	    en1.setObservations(lt1);
	    en1.setId(enc1Id);
        en1.setPatientId(patient1Id);
        en1.setEncounterClass(clazz1);
        en1.setParticipant(participant1);
        en1.setStatus(status1);
        en1.setSubject(subject1);
        
	    Encounter en2 = new Encounter();
	    
	    en2.setObservations(lt1);
	    en2.setId(enc1Id);
        en2.setPatientId(patient1Id);
        en2.setEncounterClass(clazz1);
        en2.setParticipant(participant1);
        en2.setStatus(status1);
        en2.setSubject(subject1);
        
        assertTrue(en2.equals(en1));
        assertEquals(en1.hashCode(), en2.hashCode());
	}
	
	@Test
	public void testEqualsAndHashCodeNegative() {
	    Encounter en1 = new Encounter();
	    
	    en1.setObservations(lt1);
	    en1.setId(enc1Id);
        en1.setPatientId(patient1Id);
        en1.setEncounterClass(clazz1);
        en1.setParticipant(participant1);
        en1.setStatus(status1);
        en1.setSubject(subject1);
        
	    Encounter en2 = new Encounter();
	    
	    en2.setObservations(lt1);
	    en2.setId(enc2Id);
        en2.setPatientId(patient2Id);
        en2.setEncounterClass(clazz2);
        en2.setParticipant(participant2);
        en2.setStatus(status2);
        en2.setSubject(subject2);
        
        assertFalse(en2.equals(en1));
        assertNotEquals(en1.hashCode(), en2.hashCode());
	}
	
	@Test
	public void testToString() {
		Encounter en1 = new Encounter();
		en1.setId(enc1Id);
		en1.setPatientId(patient1Id);
		en1.setEncounterClass(clazz1);
		en1.setParticipant(participant1);
		en1.setStatus(status1);
		en1.setSubject(subject1);
		
		assertEquals(en1.toString(), "Encounter{id=201521, subject=Patient/f203, encounterClass=OUTPATIENT, status=FINISHED, participant=Practitioner/f201, patientId=123, observations=null}");
	}

}

