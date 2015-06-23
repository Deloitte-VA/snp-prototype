package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Encounter;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EncounterRepositoryImplTest extends TestSetup {

	@Test
	public void testFindByDate() {
				
		LocalDate date = LocalDate.of(2015, 4, 30);
		
		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(encounterIterableMock);
		
		List<Encounter> queryResults1 = encounterRepositoryImpl.findByDate(date);
		
		verify(dbCollectionMock).find(Mockito.<Document> any());
						
		}

	}
