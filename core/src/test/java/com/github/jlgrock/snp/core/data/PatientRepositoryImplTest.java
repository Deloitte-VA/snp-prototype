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

		Document document1 = new Document() {
			{
				put("dateOfBirth", dateOfBirth);
			}
		};

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(
				iterableMock);

		List<Patient> queryResults1 = patientRepositoryImpl
				.findAllByDateOfBirth(dateOfBirth);

		verify(dbCollection).find(Mockito.<Document> any());

		for (Patient patient : queryResults1) {
			Assert.assertTrue(patients.contains(patient));
		}
	}

	public void testFindAllByFirstAndLastName() {

		String firstName = "Shane";
		String lastName = "Lewis";

		Document document2 = new Document() {
			{
				put("firstName", firstName);
				put("lastName", lastName);
			}
		};

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(
				iterableMock);

		List<Patient> queryResults2 = patientRepositoryImpl
				.findAllByFirstNameAndLastName(firstName, lastName);

		verify(dbCollection).find(Mockito.<Document> any());

		for (Patient patient : queryResults2) {
			Assert.assertTrue(patients.contains(patient));
		}
	}

	public void testFindAllByLastName() {

		String lastName = "Bhole";

		Document document3 = new Document() {
			{
				put("lastName", lastName);
			}
		};

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(
				iterableMock);

		List<Patient> queryResults3 = patientRepositoryImpl
				.findAllByLastName(lastName);

		verify(dbCollection).find(Mockito.<Document> any());

		for (Patient patient : queryResults3) {
			Assert.assertTrue(patients.contains(patient));
		}
	}

	public void testFindAllByRace() {

		Race race = Race.BLACK_AFRICAN_AMERICAN;

		Document document4 = new Document() {
			{
				put("race", race);
			}
		};

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(
				iterableMock);

		List<Patient> queryResults4 = patientRepositoryImpl.findAllByRace(race);

		verify(dbCollection).find(Mockito.<Document> any());

		for (Patient patient : queryResults4) {
			Assert.assertTrue(patients.contains(patient));
		}
	}

	public void testFindAllByGender() {

		Gender gender = Gender.MALE;

		Document document5 = new Document() {
			{
				put("gender", gender);
			}
		};

		when(dbCollection.find(Mockito.<Document> any())).thenReturn(
				iterableMock);

		List<Patient> queryResults5 = patientRepositoryImpl.findAllByRace(race);

		verify(dbCollection).find(Mockito.<Document> any());

		for (Patient patient : queryResults5) {
			Assert.assertTrue(patients.contains(patient));
		}

	}

}