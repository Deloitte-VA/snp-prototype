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
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PatientRepositoryImplTest extends TestSetup{
	
	@Test
	public void testFindAllByDateOfBirth() {

		LocalDate dateOfBirth = LocalDate.of(2001, 01, 1);

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);

		List<Patient> queryResults1 = patientRepositoryImpl.findAllByDateOfBirth(dateOfBirth);

		verify(dbCollection).find(Mockito.<Document> any());

	}
	
	@Test
	public void testFindAllByFirstAndLastName() {

		Mockito.reset(dbCollection);
		
		String firstName = "Shane";
		String lastName = "Lewis";

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);

		List<Patient> queryResults2 = patientRepositoryImpl.findAllByFirstNameAndLastName(firstName, lastName);

		verify(dbCollection).find(Mockito.<Document> any());

	}

	@Test
	public void testFindAllByLastName() {
		
		Mockito.reset(dbCollection);
		
		String lastName = "Bhole";

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);

		List<Patient> queryResults3 = patientRepositoryImpl.findAllByLastName(lastName);

		verify(dbCollection).find(Mockito.<Document> any());

	}

	@Test
	public void testFindAllByRace() {

		Mockito.reset(dbCollection);
		
		Race race = Race.BLACK_AFRICAN_AMERICAN;

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);

		List<Patient> queryResults4 = patientRepositoryImpl.findAllByRace(race);

		verify(dbCollection).find(Mockito.<Document> any());

	}

	@Test
	public void testFindAllByGender() {

		Mockito.reset(dbCollection);
		
		Gender gender = Gender.MALE;

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);

		List<Patient> queryResults5 = patientRepositoryImpl.findAllByGender(gender);

		verify(dbCollection).find(Mockito.<Document> any());

	}

}