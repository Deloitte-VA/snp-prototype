package com.github.jlgrock.snp.core.data.test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.data.EncounterRepositoryImpl;

public class EncounterRepositoryImplTest extends EncounterRepositoryImpl {

	protected EncounterRepositoryImplTest(MongoDbFactory mongoDbFactoryIn,
			EncounterReadConverter encounterReadConverterIn,
			EncounterWriteConverter encounterWriteConverterIn) {
		super(mongoDbFactoryIn, encounterReadConverterIn, encounterWriteConverterIn);
		// TODO Auto-generated constructor stub
	}
	
	@Test()
	public void testEmailGenerator() {
 
		RandomEmailGenerator obj = new RandomEmailGenerator();
		String email = obj.generate();
 
		Assert.assertNotNull(email);
		Assert.assertEquals(email, "feedback@yoursite.com");
 
	}
 
}
	
	
	
	
	
	
	
	
	
	

}
