package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
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
			//eList.add(o);
			//TODO convert
		}
		return eList;
	}

}
