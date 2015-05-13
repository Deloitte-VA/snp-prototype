package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Patient;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncounterRepositoryImplTest extends TestSetup {

	@Mock
	EncounterRepositoryImpl eri1;

	@Test
	public void testFindByDate() {

		LocalDate date = LocalDate.of(2015, 4, 30);
		eri1.findByDate(date);
		verify(dbCollection).find(Mockito.<Document> any());
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock2);
		List<Encounter> queryResults1 = encounterRepositoryImpl
				.findByDate(date);
		verify(dbCollection).find(Mockito.<Document> any());
		for (Encounter encounter : queryResults1) {
			Assert.assertTrue(encounters.contains(encounter));
		}
						
		}

	}
