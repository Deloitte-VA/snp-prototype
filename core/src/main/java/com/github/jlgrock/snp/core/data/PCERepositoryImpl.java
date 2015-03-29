package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
<<<<<<< HEAD
import com.github.jlgrock.snp.core.converters.PCEReadConverter;
import com.github.jlgrock.snp.core.converters.PCEWriteConverter;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.PCE;
import com.github.jlgrock.snp.core.domain.Patient;
=======
import com.github.jlgrock.snp.core.domain.PCE;
>>>>>>> 771057289f2add1a51aa8b3a3426b5dc01e16b5b
import com.mongodb.DBObject;

/**
 *
 */
public class PCERepositoryImpl extends AbstractRepositoryImpl<PCE, Long> implements PceRepository {

<<<<<<< HEAD
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

=======
    public PCERepositoryImpl(final MongoDbFactory mongoDbFactoryIn) {
        super(mongoDbFactoryIn);
    }

    @Override
    protected PCE convertCollection(DBObject dbObjectin) {
        return null;
    }

    @Override
    protected DBObject convertToDBObject(PCE pce) {
        return null;
    }

    @Override
    protected String getCollection() {
        return null;
    }
>>>>>>> 771057289f2add1a51aa8b3a3426b5dc01e16b5b
}
