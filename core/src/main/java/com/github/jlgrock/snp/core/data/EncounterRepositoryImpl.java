package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
<<<<<<< HEAD
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
=======
>>>>>>> 771057289f2add1a51aa8b3a3426b5dc01e16b5b
import com.github.jlgrock.snp.core.domain.Encounter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class EncounterRepositoryImpl extends
		AbstractRepositoryImpl<Encounter, Long> implements EncounterRepository {

	@Override
	protected Encounter convertCollection(DBObject dbObjectin) {
		return null;
	}

	@Override
	protected DBObject convertToDBObject(Encounter encounter) {
		return null;
	}

	protected EncounterRepositoryImpl(MongoDbFactory mongoDbFactoryIn) {
		super(mongoDbFactoryIn);
	}

	private final EncounterReadConverter encounterReadConverter;
	
	private final EncounterWriteConverter encounterWriteConverter;
	
	@Override
	protected String getCollection() {
		return null;
	}

	@Override
	public List<Encounter> findByDate(Date date) {
		List<Encounter> eList = new ArrayList<Encounter>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject("Encounter.date", date);
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
<<<<<<< HEAD
			eList.add(o);
=======
			//eList.add(o);
			//TODO convert
>>>>>>> 771057289f2add1a51aa8b3a3426b5dc01e16b5b
		}
		return eList;
	}

	@Override
	protected Encounter convertCollection(DBObject dbObjectin) {
		
		Encounter encounter = encounterReadConverter.convert(dbObjectin);
		return encounter;
		
	}

	@Override
	protected DBObject convertToDBObject(Encounter s) {
		
		DBObject dBObject = encounterWriteConverter.convert(s);
		return dBObject;
		
	}

	@Override
	protected String getCollection() {
		
		
		
		
	}

}
