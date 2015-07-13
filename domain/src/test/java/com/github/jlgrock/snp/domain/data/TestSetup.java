package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.domain.converters.EncounterReadConverter;
import com.github.jlgrock.snp.domain.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.domain.converters.AssertionWriteConverter;
import com.github.jlgrock.snp.domain.converters.PatientReadConverter;
import com.github.jlgrock.snp.domain.converters.PatientWriteConverter;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public abstract class TestSetup {

		@Mock
		MongoDbFactory mongoDbFactoryMock;

		@Mock
		MongoDatabase mongoDatabaseMock;
		
		@Mock
		PatientReadConverter patientReadConverterMock;

		@Mock
		PatientWriteConverter patientWriteConverterMock;
		
		@Mock
		EncounterReadConverter encounterReadConverterMock;
		
		@Mock
		EncounterWriteConverter encounterWriteConverterMock;
		
		@Mock
		MongoCollection<Document> dbCollectionMock;
	
		PatientRepositoryImpl patientRepositoryImpl;
		
		EncounterRepositoryImpl encounterRepositoryImpl;
		
		EmptyRepository er1;	
		
		List<Patient> patients;

		List<Document> patientDocuments;
		
		List<Document> encounterDocuments;
		
		List<ObjectId> ids;
		
		List<Encounter> encounters;
		
		IterableMock patientIterableMock;
		
		IterableMock encounterIterableMock;

        IterableMock emptyIterableMock;

		@BeforeClass
		public void setUpTests() throws Exception {
			// Required to make this work on TestNG
			MockitoAnnotations.initMocks(this);
		}

		@BeforeMethod
		public void setUp() throws Exception {

            Mockito.reset(mongoDbFactoryMock);
            Mockito.reset(mongoDatabaseMock);
            Mockito.reset(patientReadConverterMock);
            Mockito.reset(patientWriteConverterMock);
            Mockito.reset(encounterReadConverterMock);
            Mockito.reset(encounterWriteConverterMock);
            Mockito.reset(dbCollectionMock);

			Document document;

            patients = new ArrayList<>(6);
            patientDocuments = new ArrayList<>(6);
            encounterDocuments = new ArrayList<>(2);
            ids = new ArrayList<>(6);
            encounters = new ArrayList<>(2);

			// create list of encounters
			Encounter encounter;
			EncounterWriteConverter encounterWriteConverter = new EncounterWriteConverter(new AssertionWriteConverter());

			encounter = new Encounter();
			encounter.setParticipant("abc");
            encounter.setEncounterClass("yyy");
			encounter.setStatus("def");
			encounter.setId(ObjectId.get());
			encounter.setPatientId(ObjectId.get());
			encounters.add(encounter);
			document = encounterWriteConverter.convert(encounter);
			when(encounterWriteConverterMock.convert(encounter)).thenReturn(encounterWriteConverter.convert(encounter));
			encounterDocuments.add(document);

			encounter = new Encounter();
			encounter.setParticipant("def");
            encounter.setEncounterClass("zzz");
			encounter.setId(ObjectId.get());
			encounter.setPatientId(ObjectId.get());
            encounters.add(encounter);
			document = encounterWriteConverter.convert(encounter);
			when(encounterWriteConverterMock.convert(encounter)).thenReturn(encounterWriteConverter.convert(encounter));
			encounterDocuments.add(document);

			// create list of patients
			Patient patient;
			PatientWriteConverter patientWriteConverter = new PatientWriteConverter();

			patient = new Patient();
			patient.setId(ObjectId.get());
			patient.setFirstName("Justin");
			patient.setLastName("Grant");
			patient.setGender(Gender.MALE);
			patient.setDateOfBirth(LocalDate.of(2001, 1, 1));
			patients.add(patient);
			document = patientWriteConverter.convert(patient);
			when(patientWriteConverterMock.convert(patient)).thenReturn(document);
			patientDocuments.add(document);

			patient = new Patient();
			patient.setId(ObjectId.get());
			patient.setFirstName("Soyun");
			patient.setLastName("Choi");
			patient.setGender(Gender.FEMALE);
			patient.setDateOfBirth(LocalDate.of(2002, 2, 2));
			patients.add(patient);
			document = patientWriteConverter.convert(patient);
			when(patientWriteConverterMock.convert(patient)).thenReturn(document);
			patientDocuments.add(document);
			
			patient = new Patient();
			patient.setId(ObjectId.get());
			patient.setFirstName("Rodney");
			patient.setLastName("Johnson");
			patient.setGender(Gender.MALE);
			patient.setDateOfBirth(LocalDate.of(2003, 3, 3));
			patients.add(patient);
			document = patientWriteConverter.convert(patient);
			when(patientWriteConverterMock.convert(patient)).thenReturn(document);
			patientDocuments.add(document);
			
			patient = new Patient();
			patient.setId(ObjectId.get());
			patient.setFirstName("Vikram");
			patient.setLastName("Bhole");
			patient.setGender(Gender.MALE);
			patient.setDateOfBirth(LocalDate.of(2004, 4, 4));
			patients.add(patient);
			document = patientWriteConverter.convert(patient);
			when(patientWriteConverterMock.convert(patient)).thenReturn(document);
			patientDocuments.add(document);
			
			patient = new Patient();
			patient.setId(ObjectId.get());
			patient.setFirstName("Sunny");
			patient.setLastName("Vashisht");
			patient.setGender(Gender.MALE);
			patient.setDateOfBirth(LocalDate.of(2005, 5, 5));
			patients.add(patient);
			document = patientWriteConverter.convert(patient);
			when(patientWriteConverterMock.convert(patient)).thenReturn(document);
			patientDocuments.add(document);

			patient = new Patient();
			patient.setId(ObjectId.get());
			patient.setFirstName("Shane");
			patient.setLastName("Lewis");
			patient.setGender(Gender.MALE);
			patient.setDateOfBirth(LocalDate.of(2006, 6, 6));
			patients.add(patient);
			document = patientWriteConverter.convert(patient);
			when(patientWriteConverterMock.convert(patient)).thenReturn(document);
			patientDocuments.add(document);

			// make mocks return the things that we access
			when(mongoDbFactoryMock.db()).thenReturn(mongoDatabaseMock);
			patientRepositoryImpl = new PatientRepositoryImpl(mongoDbFactoryMock, patientReadConverterMock, patientWriteConverter);
			encounterRepositoryImpl = new EncounterRepositoryImpl(mongoDbFactoryMock, encounterReadConverterMock, encounterWriteConverter);
			er1 = new EmptyRepository(mongoDbFactoryMock);
			when(mongoDatabaseMock.getCollection(patientRepositoryImpl.getCollectionName())).thenReturn(dbCollectionMock);
			when(mongoDatabaseMock.getCollection(encounterRepositoryImpl.getCollectionName())).thenReturn(dbCollectionMock);
			when(mongoDatabaseMock.getCollection(er1.getCollectionName())).thenReturn(dbCollectionMock);
			
			// create list of Id values
			for (Patient p : patients) {
				ids.add(p.getId());
			}
			
			patientIterableMock = new IterableMock(patientDocuments);
									
			encounterIterableMock = new IterableMock(encounterDocuments);

            emptyIterableMock = new IterableMock(Collections.EMPTY_LIST);
		}
	
}
