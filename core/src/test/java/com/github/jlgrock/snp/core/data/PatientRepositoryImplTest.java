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
import org.mockito.Mockito;
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

        Patient patient1 = new Patient();
        patient1.setFirstName("Justin");
        patient1.setLastName("Grant");
        patient1.setGender(Gender.MALE);
        patient1.setRace(Race.CAUCASIAN);
        patient1.setDateOfBirth(LocalDate.of(2001, 1, 1));
        patients.add(patient1);
        Document patientDocument1 = new Document() {{
        	put("firstName", "Justin");
        	put("lastName", "Grant");
        	put("gender", Gender.MALE);
        	put("race", Race.CAUCASIAN);
        	put("dateOfBirth", LocalDate.of(2001, 1, 1));
        }};
        when(patientWriteConverter.convert(patient1)).thenReturn(patientDocument1);

        Patient patient2 = new Patient();
        patient2.setFirstName("Soyun");
        patient2.setLastName("Choi");
        patient2.setGender(Gender.FEMALE);
        patient2.setRace(Race.ASIAN);
        patient2.setDateOfBirth(LocalDate.of(2002, 2, 2));
        patients.add(patient2);
        Document patientDocument2 = new Document() {{
        	put("firstName", "Soyun");
        	put("lastName", "Choi");
        	put("gender", Gender.FEMALE);
        	put("race", Race.ASIAN);
        	put("dateOfBirth", LocalDate.of(2002, 2, 2));
        }};
        when(patientWriteConverter.convert(patient2)).thenReturn(patientDocument2);
        
        Patient patient3 = new Patient();
        patient3.setFirstName("Rodney");
        patient3.setLastName("Johnson");
        patient3.setGender(Gender.MALE);
        patient3.setRace(Race.BLACK_AFRICAN_AMERICAN);
        patient3.setDateOfBirth(LocalDate.of(2003, 3, 3));
        patients.add(patient3);
        Document patientDocument3 = new Document() {{
        	put("firstName", "Rodney");
        	put("lastName", "Johnson");
        	put("gender", Gender.MALE);
        	put("race", Race.BLACK_AFRICAN_AMERICAN);
        	put("dateOfBirth", LocalDate.of(2003, 3, 3));
        }};
        when(patientWriteConverter.convert(patient3)).thenReturn(patientDocument3);
        
        Patient patient4 = new Patient();
        patient4.setFirstName("Vikram");
        patient4.setLastName("Bhole");
        patient4.setGender(Gender.MALE);
        patient4.setRace(Race.ASIAN);
        patient4.setDateOfBirth(LocalDate.of(2004, 4, 4));
        patients.add(patient4);
        Document patientDocument4 = new Document() {{
        	put("firstName", "Vikram");
        	put("lastName", "Bhole");
        	put("gender", Gender.MALE);
        	put("race", Race.ASIAN);
        	put("dateOfBirth", LocalDate.of(2004, 4, 4));
        }};
        when(patientWriteConverter.convert(patient4)).thenReturn(patientDocument4);
        

        Patient patient5 = new Patient();
        patient5.setFirstName("Sunny");
        patient5.setLastName("Vashisht");
        patient5.setGender(Gender.MALE);
        patient5.setRace(Race.ASIAN);
        patient5.setDateOfBirth(LocalDate.of(2005, 5, 5));
        patients.add(patient5);
        Document patientDocument5 = new Document() {{
        	put("firstName", "Sunny");
        	put("lastName", "Vashisht");
        	put("gender", Gender.MALE);
        	put("race", Race.ASIAN);
        	put("dateOfBirth", LocalDate.of(2005, 5, 5));
        }};
        when(patientWriteConverter.convert(patient5)).thenReturn(patientDocument5);
        
        Patient patient6 = new Patient();
        patient6.setFirstName("Shane");
        patient6.setLastName("Lewis");
        patient6.setGender(Gender.MALE);
        patient6.setRace(Race.CAUCASIAN);
        patient6.setDateOfBirth(LocalDate.of(2006, 6, 6));
        patients.add(patient6);
        Document patientDocument6 = new Document() {{
        	put("firstName", "Shane");
        	put("lastName", "Lewis");
        	put("gender", Gender.MALE);
        	put("race", Race.CAUCASIAN);
        	put("dateOfBirth", LocalDate.of(2006, 6, 6));
        }};
        when(patientWriteConverter.convert(patient6)).thenReturn(patientDocument6);
        
        // make mocks return the things that we access
        when(mongoDbFactory.db()).thenReturn(mongoDatabase);
        patientRepositoryImpl = new PatientRepositoryImpl(mongoDbFactory, patientReadConverter, patientWriteConverter);
        when(mongoDatabase.getCollection(patientRepositoryImpl.getCollectionName())).thenReturn(dbCollection);
        
        
        // create list of patient Documents
        for (Patient p : patients) {
            documents.add(patientRepositoryImpl.convertToDBObject(p));
        }

        iterableMock = new IterableMock(documents);

    }

    @Test
    public void testFindAllByDateOfBirth() {

        LocalDate dateOfBirth = LocalDate.of(2001, 01, 1);

        Document query1 = new Document() {{
            put("dateOfBirth", dateOfBirth);
        }};

       
        when(dbCollection.find(Mockito.any())).thenReturn(iterableMock);

//        List<Patient> queryResults = patientRepositoryImpl.findAllByDateOfBirth(dateOfBirth);
//        
//        verify(dbCollection.find(query1));
//        for (Patient patient : patients) {
//            Assert.assertTrue(queryResults.contains(patient));
//        }
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
