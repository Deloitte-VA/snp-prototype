package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.bson.Document;
import org.mockito.Mock;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

public class ClassifiedAssertionRepositoryImplTest{

		@Mock
		MongoDbFactory mdbf1;
		
		@Mock
		ClassifiedAssertionReadConverter carc1; 

		@Mock
		ClassifiedAssertionWriteConverter cawc1;
		
		ClassifiedAssertion ca1 = new ClassifiedAssertion();
		
		Document d1 = new Document();
		
		ClassifiedAssertionRepositoryImpl cari1 = new ClassifiedAssertionRepositoryImpl(mdbf1, carc1, cawc1); 

		@Test
		public void testConvertToDomainObject(){
			
		when(cari1.convertToDomainObject(d1)).thenReturn(ca1);
		ca1 = cari1.convertToDomainObject(d1);
		verify(cari1).convertToDomainObject(d1);
		assertEquals(ca1, cari1.convertToDomainObject(d1));
		
		}
		
		@Test
		public void testConvertToDBObject(){
			
		when(cari1.convertToDBObject(ca1)).thenReturn(d1);
		d1 = cari1.convertToDBObject(ca1);
		verify(cari1).convertToDBObject(ca1);
		assertEquals(d1, cari1.convertToDBObject(ca1));
		
		}
			
}