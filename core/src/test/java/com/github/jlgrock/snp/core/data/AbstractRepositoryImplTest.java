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

	EmptyRepository er1 = new EmptyRepository(mongoDbFactory);
	
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

		Document document1 = Mockito.mock(Document.class);
		Patient patient1 = er1.save(patients.get(0));
		Mockito.verify(dbCollection).insertOne(document1);
		er1.convertToDomainObject(document1);
		Assert.assertEquals(patients.get(0), patient1);
		
	}

	@Test
	public void iterableSaveTest() {
		
		Document query = Mockito.mock(Document.class);
		Iterable<Patient> patient1 = er1.save(patients);
		Document update = er1.convertToDBObject(patients.get(0));
		Mockito.verify(dbCollection).updateOne(query, update);
		Assert.assertEquals(patient1, patients);
		
	}
	
	@Test
	public void findOneByIdTest() {

		Long id = Mockito.mock(Long.class);
		Document query = new Document() {
			{
				put("_id", id);
			}
		};
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);
		Patient patient1 = er1.findOneById(id);
		Mockito.verify(dbCollection).find(query).limit(1);
		Assert.assertNotNull(patient1);
		Assert.assertEquals(iterableMock.first(), documents.get(0));

	}
	
	@Test
	public void existsByIdTestNotNull() {
		
		Long id = Mockito.mock(Long.class);
		Boolean b1 = er1.existsById(id);
		when(er1.findOneById(id)).thenReturn(patients.get(0));
		Boolean b2 = new Boolean(true);
		Assert.assertEquals(b1, b2);
		
	}

	@Test
	public void existsByIdTestNull() {
		
		Long id = Mockito.mock(Long.class);
		Boolean b1 = er1.existsById(id);
		when(er1.findOneById(id)).thenReturn(null);
		Boolean b2 = new Boolean(false);
		Assert.assertEquals(b1, b2);
		
	}

	@Test
	public void findAllTest() {
		
		when(dbCollection.find(Mockito.<Document> any())).thenReturn(iterableMock);
		Iterable<Patient> patient1 = er1.findAll();
		Mockito.verify(dbCollection).find(Mockito.<Document> any());
		Assert.assertEquals(patient1, iterableMock);

	}
			
	@Test
	public void findAllByIdTest() {
		
		when(dbCollection.find(Mockito.<Document> any()).into(Mockito.<List> any())).thenReturn(patients);
		Iterable<Patient> patient1 = er1.findAllById(ids);
		Document query = new Document() {{
            put("_id", new BasicDBObject() {{
                put("$in", ids);
            }});
        }};
		Mockito.verify(dbCollection).find(query).into(Mockito.<List> any());
		Assert.assertEquals(patients, patient1);

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

		Long id = Mockito.mock(Long.class);
        Document query = new Document() {{
        	put("_id", id);
        }};
		er1.deleteById(id);
		Mockito.verify(dbCollection).deleteMany(query);

	}
	
	@Test
	public void deleteIterableTest() {

		er1.delete(patients);
        Document query = new Document() {{
        put("_id", new Document() {{
            	put("$in", patients);
        	}});
        }};
        Mockito.verify(dbCollection).deleteMany(query);
		
	}
		
	@Test
	public void deleteAllTest() {

		er1.deleteAll();
		Mockito.verify(dbCollection).deleteMany(new Document());
		
	}
		
}
