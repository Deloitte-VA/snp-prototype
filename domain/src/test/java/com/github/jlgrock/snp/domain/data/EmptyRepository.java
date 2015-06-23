package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.domain.converters.PatientReadConverter;
import com.github.jlgrock.snp.domain.converters.PatientWriteConverter;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmptyRepository extends
		AbstractRepositoryImpl<Patient, Long> {
	
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmptyRepository.class);

	PatientReadConverter prc1 = new PatientReadConverter();
	
	PatientWriteConverter pwc1 = new PatientWriteConverter();
	
	protected EmptyRepository(MongoDbFactory mongoDbFactoryIn) {
		super(mongoDbFactoryIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Patient convertToDomainObject(Document dbObjectin) {
		if (dbObjectin == null) {
            return null;
        }
        return prc1.convert(dbObjectin);
    }

	@Override
	protected Document convertToDBObject(Patient patientIn) {
		  if (patientIn == null) {
	            return null;
	        }
	        return pwc1.convert(patientIn);
	}

	@Override
	protected String getCollectionName() {
		LOGGER.trace("getCollectionName()");
        return "EmptyRepository";
	}
    
}
