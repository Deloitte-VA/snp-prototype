package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.PCEReadConverter;
import com.github.jlgrock.snp.core.converters.PCEWriteConverter;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.PCE;
import com.github.jlgrock.snp.core.domain.Patient;
import com.mongodb.DBObject;

/**
 *
 */
public class PCERepositoryImpl extends AbstractRepositoryImpl<PCE, Long> implements PceRepository {

	protected PCERepositoryImpl(MongoDbFactory mongoDbFactoryIn) {
		super(mongoDbFactoryIn);
		// TODO Auto-generated constructor stub
	}

	
	private final PCEReadConverter pCEReadConverter;
	
	private final PCEWriteConverter pCEWriteConverter;
	
	
	
	
	@Override
	protected PCE convertCollection(DBObject dbObjectin) {
		
		PCE pce = pCEReadConverter.convert(dbObjectin);
		return pce;
		
	}

	@Override
	protected DBObject convertToDBObject(PCE s) {
		
		DBObject dBObject = pCEWriteConverter.convert(s);
		return dBObject;
	}

	@Override
	protected String getCollection() {
		// TODO Auto-generated method stub
		return null;
	}

}
