package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class PatientRepositoryImplTest {

    @Mock
    MongoDbFactory mongoDbFactory;

    @Mock
    MongoDatabase mongoDatabase;

    @Mock
    PatientReadConverter patientReadConverter;

    @Mock
    PatientWriteConverter patientWriteConverter;

    @Mock
    MongoCollection<Document> dbCollection;

    PatientRepositoryImpl patientRepositoryImpl;

    List<Patient> patients = new ArrayList<>(6);

    List<Document> documents = new ArrayList<>(6);

    IterableMock iterableMock;

    @BeforeClass
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setUp() throws Exception {

        // create list of patients
        Patient patient;

        patient = new Patient();
        patient.setFirstName("Justin");
        patient.setLastName("Grant");
        patient.setGender(Gender.MALE);
        patient.setRace(Race.CAUCASIAN);
        patient.setDateOfBirth(LocalDate.of(2001, 1, 1));
        patients.add(patient);

        patient = new Patient();
        patient.setFirstName("Soyun");
        patient.setLastName("Choi");
        patient.setGender(Gender.FEMALE);
        patient.setRace(Race.ASIAN);
        patient.setDateOfBirth(LocalDate.of(2002, 2, 2));
        patients.add(patient);

        patient = new Patient();
        patient.setFirstName("Rodney");
        patient.setLastName("Johnson");
        patient.setGender(Gender.MALE);
        patient.setRace(Race.BLACK_AFRICAN_AMERICAN);
        patient.setDateOfBirth(LocalDate.of(2003, 3, 3));
        patients.add(patient);

        patient = new Patient();
        patient.setFirstName("Vikram");
        patient.setLastName("Bhole");
        patient.setGender(Gender.MALE);
        patient.setRace(Race.ASIAN);
        patient.setDateOfBirth(LocalDate.of(2004, 4, 4));
        patients.add(patient);

        patient = new Patient();
        patient.setFirstName("Sunny");
        patient.setLastName("Vashisht");
        patient.setGender(Gender.MALE);
        patient.setRace(Race.ASIAN);
        patient.setDateOfBirth(LocalDate.of(2005, 5, 5));
        patients.add(patient);

        patient = new Patient();
        patient.setFirstName("Shane");
        patient.setLastName("Lewis");
        patient.setGender(Gender.MALE);
        patient.setRace(Race.CAUCASIAN);
        patient.setDateOfBirth(LocalDate.of(2006, 6, 6));
        patients.add(patient);

        iterableMock = new IterableMock(documents);

        // make mocks return the things that we access
        when(mongoDbFactory.db()).thenReturn(mongoDatabase);
        patientRepositoryImpl = new PatientRepositoryImpl(mongoDbFactory, patientReadConverter, patientWriteConverter);
        when(mongoDatabase.getCollection(patientRepositoryImpl.getCollectionName())).thenReturn(dbCollection);

        // create list of patient Documents
        for (Patient p : patients) {
            documents.add(patientRepositoryImpl.convertToDBObject(p));
        }

    }

    @Test
    public void testFindAllByDateOfBirth() {

        LocalDate dateOfBirth = LocalDate.of(2001, 01, 1);

        Document query1 = new Document() {{
            put("dateOfBirth", dateOfBirth);
        }};

        verify(dbCollection.find(query1));
        when(dbCollection.find(query1)).thenReturn(iterableMock);

        List<Patient> queryResults = patientRepositoryImpl.findAllByDateOfBirth(dateOfBirth);
        for (Patient patient : patients) {
            Assert.assertTrue(queryResults.contains(patient));
        }
    }

//	public void testFindAllByFirstAndLastName(){
//
//		String firstName = "Shane";
//		String lastName = "Lewis";
//
//		 Document query2 = new Document() {{
//	            put("firstName", firstName);
//	            put("lastName", lastName);
//	        }};
//
//		when(mockedPRI.dBCollection().find(query2)).thenReturn(list);
//		when(mockedPRI.executeQueryAndTransformResults(query2)).thenReturn(list);
//		when(mockedPRI.findAllByFirstNameAndLastName(firstName, lastName)).thenReturn(list);
//
//		mockedPRI.findAllByFirstNameAndLastName(firstName, lastName);
//		verify(mockedPRI).findAllByFirstNameAndLastName(firstName, lastName);
//
//	    assertEquals(mockedPRI.findAllByFirstNameAndLastName(firstName, lastName), mockedPRI.executeQueryAndTransformResults(query2));
//	    assertEquals(mockedPRI.findAllByFirstNameAndLastName(firstName, lastName), mockedPRI.dBCollection().find(query2));
//	    assertEquals(Race.CAUCASIAN, mockedPRI.findAllByFirstNameAndLastName(firstName, lastName).get(5).getRace());
//
//	}
//
//	public void testFindAllByLastName(){
//
//		String lastName = "Bhole";
//
//		Document query3 = new Document() {{
//            put("lastName", lastName);
//        }};
//
//		when(mockedPRI.dBCollection().find(query3)).thenReturn(list);
//		when(mockedPRI.executeQueryAndTransformResults(query3)).thenReturn(list);
//		when(mockedPRI.findAllByLastName(lastName)).thenReturn(list);
//
//		mockedPRI.findAllByLastName(lastName);
//		verify(mockedPRI).findAllByLastName(lastName);
//
//	    assertEquals(mockedPRI.findAllByLastName(lastName), mockedPRI.executeQueryAndTransformResults(query3));
//	    assertEquals(mockedPRI.findAllByLastName(lastName), mockedPRI.dBCollection().find(query3));
//	    assertEquals(Gender.MALE, mockedPRI.findAllByLastName(lastName).get(3).getGender());
//
//	}
//
//	public void testFindAllByRace(){
//
//		Race race = Race.BLACK_AFRICAN_AMERICAN;
//
//		Document query4 = new Document() {{
//            put("race", race);
//        }};
//
//		when(mockedPRI.dBCollection().find(query4)).thenReturn(list);
//		when(mockedPRI.executeQueryAndTransformResults(query4)).thenReturn(list);
//		when(mockedPRI.findAllByRace(race)).thenReturn(list);
//
//		mockedPRI.findAllByRace(race);
//		verify(mockedPRI).findAllByRace(race);
//
//	    assertEquals(mockedPRI.findAllByRace(race), mockedPRI.executeQueryAndTransformResults(query4));
//	    assertEquals(mockedPRI.findAllByRace(race), mockedPRI.dBCollection().find(query4));
//	    assertEquals("Johnson", mockedPRI.findAllByRace(race).get(2).getLastName());
//
//	}
//
//	public void testFindAllByGender(){
//
//		Gender gender = Gender.MALE;
//
//	     Document query5 = new Document() {{
//	            put("gender", gender);
//	        }};
//
//		when(mockedPRI.dBCollection().find(query5)).thenReturn(list);
//		when(mockedPRI.executeQueryAndTransformResults(query5)).thenReturn(list);
//		when(mockedPRI.findAllByGender(gender)).thenReturn(list);
//
//		mockedPRI.findAllByGender(gender);
//		verify(mockedPRI).findAllByGender(gender);
//
//	    assertEquals(mockedPRI.findAllByGender(gender), mockedPRI.executeQueryAndTransformResults(query5));
//	    assertEquals(mockedPRI.findAllByGender(gender), mockedPRI.dBCollection().find(query5));
//	    assertEquals("Sunny", mockedPRI.findAllByGender(gender).get(4).getFirstName());
//
//	}

}
