package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.client.MongoCollection;

public class PatientRepositoryImplTest {
	
	@Mock 
	MongoDbFactory mdbf;
	
	@Mock
	PatientReadConverter prc;
	
	@Mock
	PatientWriteConverter pwc;
	
	@Mock
	MongoCollection<Document> dbCollection; 

	PatientRepositoryImpl mockedPRI = new PatientRepositoryImpl(mdbf, prc, pwc);
	
	private List<Patient> list = new ArrayList();
	
	
	
	@BeforeMethod
	public void setUp() throws Exception {

		Patient patient1 = new Patient();
		patient1.setFirstName("Justin");
		patient1.setLastName("Grant");
		patient1.setGender(Gender.MALE);
		patient1.setRace(Race.CAUCASIAN);
		patient1.setDateOfBirth(LocalDate.of(2001, 1, 1));
		list.add(patient1);
		
		Patient patient2 = new Patient();
		patient2.setFirstName("Soyun");
		patient2.setLastName("Choi");
		patient2.setGender(Gender.FEMALE);
		patient2.setRace(Race.ASIAN);
		patient2.setDateOfBirth(LocalDate.of(2002, 2, 2));
		list.add(patient2);
		
		Patient patient3 = new Patient();
		patient3.setFirstName("Rodney");
		patient3.setLastName("Johnson");
		patient3.setGender(Gender.MALE);
		patient3.setRace(Race.BLACK_AFRICAN_AMERICAN);
		patient3.setDateOfBirth(LocalDate.of(2003, 3, 3));
		list.add(patient3);
		
		Patient patient4 = new Patient();
		patient4.setFirstName("Vikram");
		patient4.setLastName("Bhole");
		patient4.setGender(Gender.MALE);
		patient4.setRace(Race.ASIAN);
		patient4.setDateOfBirth(LocalDate.of(2004, 4, 4));
		list.add(patient4);
	
		Patient patient5 = new Patient();
		patient5.setFirstName("Sunny");
		patient5.setLastName("Vashisht");
		patient5.setGender(Gender.MALE);
		patient5.setRace(Race.ASIAN);
		patient5.setDateOfBirth(LocalDate.of(2005, 5, 5));
		list.add(patient5);
	
		Patient patient6 = new Patient();
		patient6.setFirstName("Shane");
		patient6.setLastName("Lewis");
		patient6.setGender(Gender.MALE);
		patient6.setRace(Race.CAUCASIAN);
		patient6.setDateOfBirth(LocalDate.of(2006, 6, 6));
		list.add(patient6);

	}
	
	@Test
	public void testFindAllByDateOfBirth(){
		
		LocalDate dateOfBirth = LocalDate.of(2001, 01, 1);
		
		Document query1 = new Document() {{
            put("dateOfBirth", dateOfBirth);
        }};
        
		when(mockedPRI.dBCollection().find(query1)).thenReturn(list);
		when(mockedPRI.executeQueryAndTransformResults(query1)).thenReturn(list);
		when(mockedPRI.findAllByDateOfBirth(dateOfBirth)).thenReturn(list);
		
		mockedPRI.findAllByDateOfBirth(dateOfBirth);
		verify(mockedPRI).findAllByDateOfBirth(dateOfBirth);
		
	    assertEquals(mockedPRI.findAllByDateOfBirth(dateOfBirth), mockedPRI.executeQueryAndTransformResults(query1));
	    assertEquals(mockedPRI.findAllByDateOfBirth(dateOfBirth), mockedPRI.dBCollection().find(query1));
	    assertEquals("Justin", mockedPRI.findAllByDateOfBirth(dateOfBirth).get(0).getFirstName());
	    
	}
	
	public void testFindAllByFirstAndLastName(){

		String firstName = "Shane";
		String lastName = "Lewis";
		
		 Document query2 = new Document() {{
	            put("firstName", firstName);
	            put("lastName", lastName);
	        }};
        
		when(mockedPRI.dBCollection().find(query2)).thenReturn(list);
		when(mockedPRI.executeQueryAndTransformResults(query2)).thenReturn(list);
		when(mockedPRI.findAllByFirstNameAndLastName(firstName, lastName)).thenReturn(list);
		
		mockedPRI.findAllByFirstNameAndLastName(firstName, lastName);
		verify(mockedPRI).findAllByFirstNameAndLastName(firstName, lastName);
		
	    assertEquals(mockedPRI.findAllByFirstNameAndLastName(firstName, lastName), mockedPRI.executeQueryAndTransformResults(query2));
	    assertEquals(mockedPRI.findAllByFirstNameAndLastName(firstName, lastName), mockedPRI.dBCollection().find(query2));
	    assertEquals(Race.CAUCASIAN, mockedPRI.findAllByFirstNameAndLastName(firstName, lastName).get(5).getRace());
		
	}
		
	public void testFindAllByLastName(){

		String lastName = "Bhole";
		
		Document query3 = new Document() {{
            put("lastName", lastName);
        }};
        
		when(mockedPRI.dBCollection().find(query3)).thenReturn(list);
		when(mockedPRI.executeQueryAndTransformResults(query3)).thenReturn(list);
		when(mockedPRI.findAllByLastName(lastName)).thenReturn(list);
		
		mockedPRI.findAllByLastName(lastName);
		verify(mockedPRI).findAllByLastName(lastName);
		
	    assertEquals(mockedPRI.findAllByLastName(lastName), mockedPRI.executeQueryAndTransformResults(query3));
	    assertEquals(mockedPRI.findAllByLastName(lastName), mockedPRI.dBCollection().find(query3));
	    assertEquals(Gender.MALE, mockedPRI.findAllByLastName(lastName).get(3).getGender());
		
	}
		
	public void testFindAllByRace(){

		Race race = Race.BLACK_AFRICAN_AMERICAN;
		
		Document query4 = new Document() {{
            put("race", race);
        }};
        
		when(mockedPRI.dBCollection().find(query4)).thenReturn(list);
		when(mockedPRI.executeQueryAndTransformResults(query4)).thenReturn(list);
		when(mockedPRI.findAllByRace(race)).thenReturn(list);
		
		mockedPRI.findAllByRace(race);
		verify(mockedPRI).findAllByRace(race);
		
	    assertEquals(mockedPRI.findAllByRace(race), mockedPRI.executeQueryAndTransformResults(query4));
	    assertEquals(mockedPRI.findAllByRace(race), mockedPRI.dBCollection().find(query4));
	    assertEquals("Johnson", mockedPRI.findAllByRace(race).get(2).getLastName());
		
	}
		
	public void testFindAllByGender(){

		Gender gender = Gender.MALE;
		
	     Document query5 = new Document() {{
	            put("gender", gender);
	        }};
        
		when(mockedPRI.dBCollection().find(query5)).thenReturn(list);
		when(mockedPRI.executeQueryAndTransformResults(query5)).thenReturn(list);
		when(mockedPRI.findAllByGender(gender)).thenReturn(list);
		
		mockedPRI.findAllByGender(gender);
		verify(mockedPRI).findAllByGender(gender);
		
	    assertEquals(mockedPRI.findAllByGender(gender), mockedPRI.executeQueryAndTransformResults(query5));
	    assertEquals(mockedPRI.findAllByGender(gender), mockedPRI.dBCollection().find(query5));
	    assertEquals("Sunny", mockedPRI.findAllByGender(gender).get(4).getFirstName());
		
	}

}
