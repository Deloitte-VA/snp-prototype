package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
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
public class EncounterRepositoryImpl extends AbstractRepositoryImpl<Encounter, Long> implements EncounterRepository {

    protected EncounterRepositoryImpl(MongoDbFactory mongoDbFactoryIn) {
		super(mongoDbFactoryIn);
	}

	@Override
    public List<Encounter> findByDate(Date date) {
		
			List<Encounter> eList = new ArrayList<Encounter>();
			DBCollection dbc1 = dBCollection();
			BasicDBObject query = new BasicDBObject ("Encounter.date", date); 
			DBCursor x = dbc1.find(query);
	        for(Encounter o:x){
	        	eList.add(o);	
	        }
			return eList;
    }

}
