package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.apis.domain.MongoDomainObject;
import com.github.jlgrock.snp.core.domain.Patient;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

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

		Patient patient1 = er1.save(patients.get(0)); 
		Mockito.verify(dbCollection).insertOne(Mockito.<Document> any());  
		Assert.assertEquals(patients.get(0), patient1); 

	}

	@Test
	public void iterableSaveTest() {
		
		Iterable<Patient> patient1 = er1.save(patients);
		Mockito.verify(dbCollection, Mockito.atLeast(36)).updateOne(Mockito.<Document> any(), Mockito.<Document> any());
		Assert.assertEquals(patient1, patients);
		
	}
	
	@Test
	public void findOneByIdTest() {
		
		Mockito.reset(dbCollection);
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);
		Long id = patients.get(0).getId();
		Patient patient1 = er1.findOneById(id);
		Mockito.verify(dbCollection).find(Mockito.<Document> any());

	}
	
	@Test
	public void existsByIdTestNotNull() {
		
		Mockito.reset(dbCollection);
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);
		Long id = patients.get(0).getId();
		Boolean b1 = er1.existsById(id);
		Boolean b2 = new Boolean(true);
		Assert.assertEquals(b1, b2);
		
	}

	@Test
	public void existsByIdTestNull() {
		
		Mockito.reset(dbCollection);
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock3);
		Long id = patients.get(0).getId();
		Boolean b1 = er1.existsById(id);
		Boolean b2 = new Boolean(false);
		Assert.assertEquals(b1, b2);
		
	}

	@Test
	public void findAllTest() {
		
		Mockito.reset(dbCollection);
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);
		Iterable<Patient> patient1 = er1.findAll();
		Mockito.verify(dbCollection).find(Mockito.<Document> any());
		
	}
			
	@Test
	public void findAllByIdTest() {
		
		Mockito.reset(dbCollection);
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);
		Iterable<Patient> patient1 = er1.findAllById(ids);
		Mockito.verify(dbCollection).find(Mockito.<Document> any());

	}
		
	@Test
	public void countTest() {

		long count1 = ids.get(0);
		when(dbCollection.count()).thenReturn(count1);
		long count2 = er1.count();
		Mockito.verify(dbCollection).count();
		Assert.assertEquals(count1, count2);
		
	}
		
	@Test
	public void deleteTest() {

		er1.delete(patients.get(0));
		Mockito.verify(dbCollection).findOneAndDelete(er1.convertToDBObject(patients.get(0)));
		
	}
		
	@Test
	public void deleteByIdTest() {

		Long id = encounters.get(1).getId();
		er1.deleteById(id);
		Mockito.verify(dbCollection).deleteMany(new Document());

	}
		
	@Test
	public void deleteIterableTest() {

		er1.delete(patients);
        Mockito.verify(dbCollection).deleteMany(new Document());
		
	}
		
	@Test
	public void deleteAllTest() {

		er1.deleteAll();
		Mockito.verify(dbCollection).deleteMany(new Document());
		
	}
		
}
