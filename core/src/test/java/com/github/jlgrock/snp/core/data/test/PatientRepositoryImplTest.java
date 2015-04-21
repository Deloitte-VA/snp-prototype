package com.github.jlgrock.snp.core.data.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.data.PatientRepositoryImpl;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import static org.testng.AssertJUnit.assertNotNull;

public class PatientRepositoryImplTest {

	@Test
	public void test() {

		String firstName = Mockito.mock(String.class);
		String lastName = Mockito.mock(String.class);
		Date date = Mockito.mock(Date.class);
		Race race = Mockito.mock(Race.class);
		Gender gender = Mockito.mock(Gender.class);
		Patient patient1 = Mockito.mock(Patient.class);
		Patient patient2 = Mockito.mock(Patient.class);
		Patient patient3 = Mockito.mock(Patient.class);
		MongoDbFactory mongoDBFactory = Mockito.mock(MongoDbFactory.class);
		PatientReadConverter patientReadConverter = Mockito.mock(PatientReadConverter.class);
		PatientWriteConverter patientWriteConverter = Mockito.mock(PatientWriteConverter.class);
		DBCollection dBCollectionMock = Mockito.mock(DBCollection.class);
		DB dB = Mockito.mock(DB.class);
		DBCollection dBCollectionSpy = Mockito.spy(dBCollectionMock);
		
		List<Patient> patientList = new ArrayList<>();
		patientList.add(0, patient1);
		patientList.add(1, patient2);
		patientList.add(2, patient3);
		
		//DBCursor dBCursor = new DBCursor();
		
		
		PatientRepositoryImpl test1 = new PatientRepositoryImpl(mongoDBFactory, patientReadConverter, patientWriteConverter);
		
		
		BasicDBObject lastName2 = new BasicDBObject() {
			{
				put("lastName", lastName);
			}
		};

		//Mockito.when(dBCollectionSpy.find(lastName2)).thenReturn(patientList);
		
		
		//asssertEquals(dBCollectionSpy.find(lastName),test1.findAllByLastName(lastName2));

	

		/**
		 * assertNotNull(pre1.findAllByLastName(st2));
		 * Mockito.when(pre1.findAllByLastName(st2)).thenReturn(pl1);
		 * Mockito.when(dbcnew.find()
		 * 
		 * 
		 * 
		 * assertNotNull(pre1.findAllByFirstNameAndLastName(st1, st2));
		 * Mockito.when(pre1.findAllByFirstNameAndLastName(st1,
		 * st2)).thenReturn(pl1);
		 * 
		 * assertNotNull(pre1.findAllByDateOfBirth(dt1));
		 * Mockito.when(pre1.findAllByDateOfBirth(dt1)).thenReturn(pl1);
		 * 
		 * assertNotNull(pre1.findAllByGender(gn1));
		 * Mockito.when(pre1.findAllByGender(gn1)).thenReturn(pl1);
		 * 
		 * assertNotNull(pre1.findAllByRace(rc1));
		 * Mockito.when(pre1.findAllByRace(rc1)).thenReturn(pl1);
		 **/
	}

}
