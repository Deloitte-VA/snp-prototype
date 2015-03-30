package com.github.jlgrock.snp.core.data.test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.domain.MongoDomainObject;
import com.github.jlgrock.snp.core.data.AbstractRepositoryImpl;
import com.mongodb.DBObject;

public class AbstractRepositoryImplTest extends AbstractRepositoryImpl {

	protected AbstractRepositoryImplTest(MongoDbFactory mongoDbFactoryIn) {
		super(mongoDbFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object save(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected MongoDomainObject convertToDomainObject(DBObject dbObjectin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DBObject convertToDBObject(MongoDomainObject s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getCollectionName() {
		// TODO Auto-generated method stub
		return null;
	}

}
