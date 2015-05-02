package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.Encounter;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EncounterRepositoryImplTest {

	@Mock
	EncounterRepositoryImpl mockedERI;
	
	@Mock
	MongoCollection<Document> dbCollection; 
	
	private List<Encounter> list = new ArrayList();
	
	Long ln1 = new Long(201521);
	Long pt1 = new Long(4334l);
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		Encounter encounter1 = new Encounter();
		encounter1.setDate(LocalDate.of(2015, 4, 30));
		encounter1.setReasonForVisit("Sprained Ankle");
		encounter1.setType(201523);
		encounter1.setId(ln1);
		encounter1.setPatientId(pt1);
		list.add(encounter1);
	}
    		
//	@Test
//	public void testFindByDate(){
//
//		LocalDate date = LocalDate.of(2015, 4, 30);
//
//		Document query1 = new Document() {{
//	            put("date", date);
//	        }};
//
//		when(mockedERI.dBCollection().find(query1)).thenReturn(list);
//		when(mockedERI.executeQueryAndTransformResults(query1)).thenReturn(list);
//		when(mockedERI.findByDate(date)).thenReturn(list);
//
//		mockedERI.findByDate(date);
//		verify(mockedERI).findByDate(date);
//
//	    assertEquals(mockedERI.findByDate(date), mockedERI.executeQueryAndTransformResults(query1));
//	    assertEquals(mockedERI.findByDate(date), mockedERI.dBCollection().find(query1));
//	    assertEquals(ln1, mockedERI.findByDate(date).get(0).getId());
//
//	}
		
}
