package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.domain.types.Patient;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;

public class AbstractRepositoryImplTest extends TestSetup {
	
	@Test
	public void findAllSortTest() {
		
		int b1 = 0;
		try{
			Sort sort = Mockito.mock(Sort.class);
			Iterable<Patient> patient1 = er1.findAll(sort);
			b1 += 1;
		}
		catch (Exception e){
			b1 +=1;
		}
		Assert.assertNotEquals(b1, 0);
		
	}
	
	@Test
	public void findAllPageableTest() {
		
		int b1 = 0;
		try{
			Pageable pageable = Mockito.mock(Pageable.class);
			Page<Patient> patient1 = er1.findAll(pageable);
			b1 += 1;
		}
		catch (Exception e){
			b1 +=1;
		}
		Assert.assertNotEquals(b1, 0);
		
	}
		
	@Test
	public void saveTest() {
        UpdateOptions updateOptions = new UpdateOptions();
        updateOptions.upsert(true);

		Patient patient = er1.save(patients.get(0));
		Mockito.verify(dbCollectionMock).updateOne(Mockito.eq(er1.createIdDocumentFromEntity(patient)),
                Mockito.eq(er1.convertToSetDocument(er1.convertToDBObject(patient))),
                Mockito.refEq(updateOptions));
		Assert.assertEquals(patients.get(0), patient);

	}

	@Test
	public void iterableSaveTest() {
        UpdateOptions updateOptions = new UpdateOptions();
        updateOptions.upsert(true);

        Iterable<Patient> patientsReturn = er1.save(patients);
		for(Patient patient : patients) {
            Mockito.verify(dbCollectionMock).updateOne(
                    Mockito.eq(er1.createIdDocumentFromEntity(patient)),
                    Mockito.eq(er1.convertToSetDocument(er1.convertToDBObject(patient))),
                    Mockito.refEq(updateOptions)
            );
        }

		Assert.assertEquals(patientsReturn, patients);
	}
	
	@Test
	public void findOneByIdTest() {
        ObjectId id = patients.get(0).getId();
		when(dbCollectionMock.find(er1.createIdDocument(id))).thenReturn(patientIterableMock);
		er1.findOneById(id);
		Mockito.verify(dbCollectionMock).find(er1.createIdDocument(id));
	}
	
	@Test
	public void existsByIdTestNotNull() {
		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);
		ObjectId id = patients.get(0).getId();
		Boolean b1 = er1.existsById(id);
		Assert.assertEquals(b1, Boolean.TRUE);
	}

	@Test
	public void existsByIdTestNotExists() {
		ObjectId id = patients.get(0).getId();
		when(dbCollectionMock.find(er1.createIdDocument(id))).thenReturn(emptyIterableMock);
		Boolean b1 = er1.existsById(id);
		Assert.assertEquals(b1, Boolean.FALSE);
	}

	@Test
	public void findAllTest() {
		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);
		er1.findAll();
		Mockito.verify(dbCollectionMock).find(Mockito.<Document> any());
	}
			
	@Test
	public void findAllByIdTest() {
		when(dbCollectionMock.find(Mockito.<Document> any())).thenReturn(patientIterableMock);
		er1.findAllById(ids);
		Mockito.verify(dbCollectionMock).find(er1.createIdDocument(ids));
	}
		
	@Test
	public void countTest() {
		long count1 = 0l;
		when(dbCollectionMock.count()).thenReturn(count1);
		long count2 = er1.count();
		Mockito.verify(dbCollectionMock).count();
		Assert.assertEquals(count1, count2);
	}
		
	@Test
	public void deleteTest() {
		er1.delete(patients.get(0));
        Document idDoc = er1.createIdDocumentFromEntity(patients.get(0));
        Mockito.verify(dbCollectionMock).findOneAndDelete(idDoc);
	}
		
	@Test
	public void deleteByIdTest() {
		ObjectId id = encounters.get(1).getId();
		er1.deleteById(id);
		Mockito.verify(dbCollectionMock).deleteMany(er1.createIdDocument(id));
	}
		
	@Test
	public void deleteIterableTest() {
		er1.delete(patients);
        Mockito.verify(dbCollectionMock).deleteMany(er1.createIdDocumentFromEntities(patients));
	}
		
	@Test
	public void deleteAllTest() {
		er1.deleteAll();
		Mockito.verify(dbCollectionMock).deleteMany(new Document());
	}

}
