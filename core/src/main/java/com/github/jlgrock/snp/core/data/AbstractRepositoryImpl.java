package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.integration.sample.PocDemoCheck;
import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.core.connection.SimpleMongoDbFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public abstract class AbstractRepositoryImpl<S, T extends Serializable> implements MongoRepository<S, T> {

	public abstract S convertCollection(final DBObject dbObjectin);	
	
	public abstract DBObject convertToDBObject(final S s);
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractRepositoryImpl.class);
	
	private final MongoDbFactory mongoDbFactory;

	protected AbstractRepositoryImpl(final MongoDbFactory mongoDbFactoryIn){
		
		mongoDbFactory = mongoDbFactoryIn;
			
	}
	
	protected abstract String getCollection();


	private DBCollection dBCollection(){
       	DB db = null;
    	try {
			db = mongoDbFactory.db();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
       	return db.getCollection(getCollection());

	}
	
    @Override
    public Iterable<S> findAll(Sort sort) {
    	List<S> sList = new ArrayList<S>();
	    DBCollection dbc1 = dBCollection();
    	BasicDBObject query = new BasicDBObject ("$in", sort); 
    	DBCursor x = dbc1.find(query);
        for(DBObject o:x){
        	sList.add(convertCollection(o));
        	}
		return sList;
    }

    
    //To Do    

    @Override
    public Page<S> findAll(Pageable pageable) {
    	List<S> sList = new ArrayList<S>();
    	 DBCollection dbc1 = dBCollection();
    	BasicDBObject query = new BasicDBObject (pageable).skip(start).limit(count); 
    	dbc1.find(query);
        for(DBObject o:x){
        	sList.add(convertCollection(o));
        	}
		return sList;
    }

    @Override
    public <S1 extends S> S save(S1 entity) {
 
    	DBCollection dbc1 = dBCollection();
    	dbc1.save(convertToDBObject(entity));
    }

    @Override
    public <S1 extends S> Iterable<S1> save(Iterable<S1> entities) {
    	
    	DBCollection dbc1 = dBCollection();
        for(S1 o:entities){
    	dbc1.save(convertToDBObject(o));
        }
    }

    @Override
    public S findOne(T t) {
    	List<S> sList = new ArrayList<S>();
    	
    	DBCollection dbc1 = dBCollection();
    	BasicDBObject query = new BasicDBObject ("$eq", t); 
    	DBObject x = dbc1.findOne(query);
    	return convertCollection(x);
    }

    @Override
    public boolean exists(T t) { 
    	
    	DBCollection dbc1 = dBCollection();
    	BasicDBObject query = new BasicDBObject ("$eq", t); 
    	DBCursor x = dbc1.find(query);
    	if(x != null){ return true;}
    	else{return false;}
        	}
     
    @Override
    public Iterable<S> findAll() {
    	List<S> sList = new ArrayList<S>();
    	DBCollection dbc1 = dBCollection();
    	DBCursor x = dbc1.find();
        for(DBObject o:x){
        	sList.add(convertCollection(o));	
        }
		return sList;
    }

    @Override
    public Iterable<S> findAll(Iterable<T> ids) {
    	List<S> sList = new ArrayList<S>();
    	DBCollection dbc1 = dBCollection();
    	DBCursor x = dbc1.find(query);
        for(DBObject o:x){
        	sList.add(convertCollection(o));
        	}
		return sList;
    }
    
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(T t) {

    }

    @Override
    public void delete(S entity) {

    }

    @Override
    public void delete(Iterable<? extends S> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
