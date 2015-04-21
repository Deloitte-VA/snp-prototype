package com.github.jlgrock.snp.core.data.test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.core.data.ClassifiedAssertionRepositoryImpl;

public class ClassifiedAssertionRepositoryImplTest extends ClassifiedAssertionRepositoryImpl {

	public ClassifiedAssertionRepositoryImplTest(
			MongoDbFactory mongoDbFactoryIn,
			ClassifiedAssertionReadConverter classifiedAssertionReadConverterIn,
			ClassifiedAssertionWriteConverter classifiedAssertionWriteConverterIn) {
		super(mongoDbFactoryIn, classifiedAssertionReadConverterIn,
				classifiedAssertionWriteConverterIn);
		// TODO Auto-generated constructor stub
	}

}
