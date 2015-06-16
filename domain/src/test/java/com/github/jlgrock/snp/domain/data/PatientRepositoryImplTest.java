package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PatientRepositoryImplTest extends TestSetup{
	
	@Test
	public void testFindAllByDateOfBirth() {

		LocalDate dateOfBirth = LocalDate.of(2001, 01, 1);

		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);

		List<Patient> queryResults1 = patientRepositoryImpl.findAllByDateOfBirth(dateOfBirth);

		verify(dbCollectionMock).find(Mockito.<Document> any());

	}
	
	@Test
	public void testFindAllByFirstAndLastName() {

		Mockito.reset(dbCollectionMock);
		
		String firstName = "Shane";
		String lastName = "Lewis";

		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);

		List<Patient> queryResults2 = patientRepositoryImpl.findAllByFirstNameAndLastName(firstName, lastName);

		verify(dbCollectionMock).find(Mockito.<Document> any());

	}

	@Test
	public void testFindAllByLastName() {
		
		Mockito.reset(dbCollectionMock);
		
		String lastName = "Bhole";

		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);

		List<Patient> queryResults3 = patientRepositoryImpl.findAllByLastName(lastName);

		verify(dbCollectionMock).find(Mockito.<Document> any());

	}

	@Test
	public void testFindAllByGender() {

		Mockito.reset(dbCollectionMock);
		
		Gender gender = Gender.MALE;

		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);

		List<Patient> queryResults5 = patientRepositoryImpl.findAllByGender(gender);

		verify(dbCollectionMock).find(Mockito.<Document> any());

	}

}