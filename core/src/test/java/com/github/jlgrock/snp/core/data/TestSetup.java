package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.converters.ObservationReadConverter;
import com.github.jlgrock.snp.core.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class TestSetup{

		@Mock
		MongoDbFactory mongoDbFactory;

		@Mock
		MongoDatabase mongoDatabase;
		
		@Mock
		PatientReadConverter patientReadConverter;

		@Mock
		PatientWriteConverter patientWriteConverter;
		
		@Mock
		EncounterReadConverter encounterReadConverter; 
		
		@Mock
		EncounterWriteConverter encounterWriteConverter;
		
		@Mock
		MongoCollection<Document> dbCollection;
	
		PatientRepositoryImpl patientRepositoryImpl;
		
		EncounterRepositoryImpl encounterRepositoryImpl;
		
		EmptyRepository er1;	
		
		List<Patient> patients = new ArrayList<>(6);

		List<Document> documents = new ArrayList<>(6);
		
		List<Document> documents2 = new ArrayList<>(2);
		
		List<Document> documents3 = new ArrayList<>(1);
		
		List<Long> ids = new ArrayList<>(6);
		
		List<Encounter> encounters = new ArrayList<>(2); 
		
		IterableMock iterableMock;
		
		IterableMock iterableMock2;
		
		IterableMock iterableMock3;
		
		@BeforeClass
		public void setUpTests() throws Exception {
			// Required to make this work on TestNG
			MockitoAnnotations.initMocks(this);
		}

		@BeforeMethod
		public void setUp() throws Exception {

			// create list of encounters
			Encounter encounter1 = new Encounter();
			encounter1.setDate(LocalDate.of(2015, 4, 30));
			encounter1.setReasonForVisit("Sprained Ankle");
			encounter1.setType(201523);
			encounter1.setId(201521l);
			encounter1.setPatientId(4334l);
			encounters.add(encounter1);
			Document encounterDocument1 = new Document() {
				{
					put("date", LocalDate.of(2015, 4, 30));
					put("reason_for_visit", "Sprained Ankle");
					put("type", 201523);
					put("_id", 201521l);
					put("patient", 4334l);
				}
			};
			when(encounterWriteConverter.convert(encounter1)).thenReturn(
					encounterDocument1);
			
			Encounter encounter2 = new Encounter();
			encounter2.setDate(LocalDate.of(2015, 5, 1));
			encounter2.setReasonForVisit("Sprained Wrist");
			encounter2.setType(201524);
			encounter2.setId(201522l);
			encounter2.setPatientId(4335l);
			encounters.add(encounter2);
			Document encounterDocument2 = new Document() {
				{
					put("date", LocalDate.of(2015, 4, 30));
					put("reason_for_visit", "Sprained Ankle");
					put("type", 201523);
					put("_id", 201521l);
					put("patient", 4334l);
				}
			};
			when(encounterWriteConverter.convert(encounter2)).thenReturn(
					encounterDocument2);
			
			// create list of patients
			Patient patient1 = new Patient();
			patient1.setId(1l);
			patient1.setFirstName("Justin");
			patient1.setLastName("Grant");
			patient1.setGender(Gender.MALE);
			patient1.setRace(Race.CAUCASIAN);
			patient1.setDateOfBirth(LocalDate.of(2001, 1, 1));
			patients.add(patient1);
			Document patientDocument1 = new Document() {
				{	
			        put("middle_name", "Deloitte");
			        put("_id", 1l);
					put("first_name", "Justin");
					put("last_name", "Grant");
					put("gender", 1);
					put("race", 1);
					put("dob", 10000);
				}
			};
			when(patientWriteConverter.convert(patient1)).thenReturn(
					patientDocument1);
			
			Patient patient2 = new Patient();
			patient2.setId(2l);
			patient2.setFirstName("Soyun");
			patient2.setLastName("Choi");
			patient2.setGender(Gender.FEMALE);
			patient2.setRace(Race.ASIAN);
			patient2.setDateOfBirth(LocalDate.of(2002, 2, 2));
			patients.add(patient2);
			Document patientDocument2 = new Document() {
				{
			        put("middle_name", "Deloitte");
			        put("_id", 2l);
					put("first_name", "Soyun");
					put("last_name", "Choi");
					put("gender", 2);
					put("race", 2);
					put("dob", 10000);
				}
			};
			when(patientWriteConverter.convert(patient2)).thenReturn(
					patientDocument2);
			
			Patient patient3 = new Patient();
			patient3.setId(3l);
			patient3.setFirstName("Rodney");
			patient3.setLastName("Johnson");
			patient3.setGender(Gender.MALE);
			patient3.setRace(Race.BLACK_AFRICAN_AMERICAN);
			patient3.setDateOfBirth(LocalDate.of(2003, 3, 3));
			patients.add(patient3);
			Document patientDocument3 = new Document() {
				{
			        put("middle_name", "Deloitte");
			        put("_id", 3l);
					put("first_name", "Rodney");
					put("last_name", "Johnson");
					put("gender", 1);
					put("race", 4);
					put("dob", 10000);
				}
			};
			when(patientWriteConverter.convert(patient3)).thenReturn(
					patientDocument3);
			
			Patient patient4 = new Patient();
			patient4.setId(4l);
			patient4.setFirstName("Vikram");
			patient4.setLastName("Bhole");
			patient4.setGender(Gender.MALE);
			patient4.setRace(Race.ASIAN);
			patient4.setDateOfBirth(LocalDate.of(2004, 4, 4));
			patients.add(patient4);
			Document patientDocument4 = new Document() {
				{
			        put("middle_name", "Deloitte");
			        put("_id", 4l);
					put("first_name", "Vikram");
					put("last_name", "Bhole");
					put("gender", 1);
					put("race", 2);
					put("dob", 10000);
				}
			};
			when(patientWriteConverter.convert(patient4)).thenReturn(
					patientDocument4);
			
			Patient patient5 = new Patient();
			patient5.setId(5l);
			patient5.setFirstName("Sunny");
			patient5.setLastName("Vashisht");
			patient5.setGender(Gender.MALE);
			patient5.setRace(Race.ASIAN);
			patient5.setDateOfBirth(LocalDate.of(2005, 5, 5));
			patients.add(patient5);
			Document patientDocument5 = new Document() {
				{
			        put("middle_name", "Deloitte");
			        put("_id", 5l);
					put("first_name", "Sunny");
					put("last_name", "Vashisht");
					put("gender", 1);
					put("race", 2);
					put("dob", 10000);
				}
			};
			when(patientWriteConverter.convert(patient5)).thenReturn(
					patientDocument5);

			Patient patient6 = new Patient();
			patient6.setId(6l);
			patient6.setFirstName("Shane");
			patient6.setLastName("Lewis");
			patient6.setGender(Gender.MALE);
			patient6.setRace(Race.CAUCASIAN);
			patient6.setDateOfBirth(LocalDate.of(2006, 6, 6));
			patients.add(patient6);
			Document patientDocument6 = new Document() {
				{
			        put("middle_name", "Deloitte");
			        put("_id", 6l);
					put("first_name", "Shane");
					put("last_name", "Lewis");
					put("gender", 1);
					put("race", 1);
					put("dob", 10000);
				}
			};
			when(patientWriteConverter.convert(patient6)).thenReturn(
					patientDocument6);

			// make mocks return the things that we access
			when(mongoDbFactory.db()).thenReturn(mongoDatabase);
			patientRepositoryImpl = new PatientRepositoryImpl(mongoDbFactory, patientReadConverter, patientWriteConverter);
			encounterRepositoryImpl = new EncounterRepositoryImpl(mongoDbFactory, encounterReadConverter, encounterWriteConverter);
			er1 = new EmptyRepository(mongoDbFactory);
			when(mongoDatabase.getCollection(patientRepositoryImpl.getCollectionName())).thenReturn(dbCollection);
			when(mongoDatabase.getCollection(encounterRepositoryImpl.getCollectionName())).thenReturn(dbCollection);
			when(mongoDatabase.getCollection(er1.getCollectionName())).thenReturn(dbCollection);
			
			// create list of patient Documents
			for (Patient p : patients) {
				documents.add(patientRepositoryImpl.convertToDBObject(p));
			}

			// create list of Id values
			for (Patient p : patients) {
				ids.add(p.getId());
			}
			
			// creat list of encounter Documents
			documents2.add(encounterDocument1);
			documents2.add(encounterDocument2);
			    
			iterableMock = new IterableMock(documents);
									
			iterableMock2 = new IterableMock(documents2);
			
			Document doc3 = null;
			
			documents3.add(doc3);
			
			iterableMock3 = new IterableMock(documents3);
			
		}
	
}
