package com.github.jlgrock.snp.core.data;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.bson.Document;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.apis.domain.MongoDomainObject;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Patient;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EmptyRepository extends
		AbstractRepositoryImpl<Patient, Long> {

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
		// TODO Auto-generated method stub
		return null;
	}

}
