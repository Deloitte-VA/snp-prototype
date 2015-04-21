package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.apis.domain.MongoDomainObject;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This is an Abstract implementation of a repository class for Java
 *
 * @param <S> the type of the domain object to store
 * @param <T> the type of the ID
 */
public abstract class AbstractRepositoryImpl<S extends MongoDomainObject<T>, T extends Serializable>
		implements MongoRepository<S, T> {

	/**
	 * Changes a DBObject into a domain object
	 * 
	 * @param dbObjectin
	 *            Data Base Object is an input parameter used in this method
	 * @return the method returns a Serializable S object as output
	 */
	protected abstract S convertToDomainObject(final DBObject dbObjectin);

	/**
	 * Changes an S object into a DBObject
	 * 
	 * @param s
	 *            Serializable object is used as an input parameter for this
	 *            method
	 * @return the method returns an object of type DBObject
	 */
	protected abstract DBObject convertToDBObject(final S s);

	/**
	 * LOGGER is used to generate an error message if the database artifacts
	 * cannot be accesses
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractRepositoryImpl.class);

	/**
	 * variable of type MongoDbFactory is used to create/access a MongoDB
	 * instance
	 */
	private final MongoDbFactory mongoDbFactory;

	/**
	 * Constructor used to set values for class variables
	 * 
	 * @param mongoDbFactoryIn the variable is set to the parameter
	 *            mongoDbFactoryIn by the constructor
	 */
	protected AbstractRepositoryImpl(final MongoDbFactory mongoDbFactoryIn) {
		mongoDbFactory = mongoDbFactoryIn;
	}

	/**
	 * 
	 * @return method will return a string
	 */
	protected abstract String getCollectionName();

	/**
	 * 
	 * @return method returns a DBCollection object which contains a collection
	 *         of data from a MongoDB instance.
	 */
	protected DBCollection dBCollection() {
		DB db = null;
		try {
			db = mongoDbFactory.db();
		} catch (DataAccessException e) {
			LOGGER.error("Could not get access to the data.", e);
		}
		String collectionName = getCollectionName();
		if (collectionName == null) {
			LOGGER.error("Collection name has not been set on class " + this.getClass().getSimpleName() + ", code will fail until this is remedied");
			return null;
		}
		DBCollection dbCollection = db.getCollection(collectionName);
		dbCollection.setWriteConcern(WriteConcern.JOURNALED);
		return dbCollection;
	}

	/**
	 * Determine the id to use.
	 * 
	 * @param obj
	 *            the object to turn into an id
	 * @return an id that can be serialized. If it cannot be serialized, the
	 *         optional is returned and an error is logged.
	 */
	private Optional<?> serializeId(final Object obj) {
		Optional<?> returnval;
		if (obj instanceof Number || obj instanceof Binary
				|| obj instanceof ObjectId || obj instanceof DBObject) {
			returnval = Optional.of(obj);
		} else if (obj instanceof MongoDomainObject) {
			returnval = Optional.of(((MongoDomainObject) obj).getId());
		} else {
			LOGGER.error("Cannot serialize id for class of type "
					+ obj.getClass());
			return Optional.empty();
		}
		return returnval;
	}

	private void executeQuery1(BasicDBObject query){
		DBCollection dbc1 = dBCollection();
		dbc1.findAndRemove(query);
		}
	
	private List<Object> serializeIds(final List<Object> objs) {
		List<Object> list = new ArrayList<>();
		for (Object obj : objs) {
			Optional<?> o = serializeId(obj);
			if (o.isPresent()) {
				list.add(o.get());
			}
		}
		return list;
	}

	@Override
	public Iterable<S> findAll(final Sort sort) {
		throw new UnsupportedOperationException("Method is not currently being utilized.");
	}

	@Override
	public Page<S> findAll(final Pageable pageable) {
		throw new UnsupportedOperationException("Method is not currently being utilized.");
	}

	@Override
	public <S1 extends S> S save(final S1 entity) {
		DBCollection dbc1 = dBCollection();
		dbc1.save(convertToDBObject(entity));
		return entity;
	}

	@Override
	public <S1 extends S> Iterable<S1> save(final Iterable<S1> entities) {
		DBCollection dbc1 = dBCollection();
		for (S1 o : entities) {
			dbc1.save(convertToDBObject(o));
		}
		return entities;
	}

	@Override
	public S findOneById(final T id) {
		LOGGER.info("find(id=" + id + ")");
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("_id", id);
		}};
		DBObject x = dbc1.findOne(query);
		return convertToDomainObject(x);
	}

	@Override
	public boolean existsById(final T id) {
		LOGGER.info("exists(id=" + id + ")");
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("_id", id);
		}};
		DBCursor x = dbc1.find(query);
		if (x != null) {
			return true;
		}
		return false;
	}

	@Override
	public Iterable<S> findAll() {
		LOGGER.info("findAll()");
		List<S> sList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		DBCursor x = dbc1.find();
		for (DBObject o : x) {
			sList.add(convertToDomainObject(o));
		}
		return sList;
	}

	@Override
	public Iterable<S> findAllById(final Iterable<T> ids) {
		LOGGER.info("findall(ids=" + Lists.newArrayList(ids).stream().map(id -> id.toString()).collect(Collectors.joining(", ")) + ")");
		List<S> sList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("_id", new BasicDBObject() {{
				put("$in", ids);
			}});
		}};

		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			sList.add(convertToDomainObject(o));
		}
		return sList;
	}

	@Override
	public long count() {
		DBCollection dbc1 = dBCollection();
		return dbc1.count();
	}

	@Override
	public void delete(final S entity) {
		LOGGER.info("deleteById(entity=" + entity + ")");
		DBCollection dbc1 = dBCollection();
		dbc1.remove(convertToDBObject(entity));
	}

	@Override
	public void deleteById(final T id) {
		LOGGER.info("deleteById(id=" + id + ")");
		BasicDBObject query = new BasicDBObject() {{
			put("_id", id);
		}};
		executeQuery1(query);
	}
	
	@Override
	public void delete(final Iterable<? extends S> entities) {
		LOGGER.info("delete(ids=" + Lists.newArrayList(entities).stream().map(id -> id.toString()).collect(Collectors.joining(", ")) + ")");
		BasicDBObject query = new BasicDBObject() {{
			put("_id", new BasicDBObject() {{
				put("$in", entities);
			}});
		}};
		executeQuery1(query);
	}

	@Override
	public void deleteAll() {
		LOGGER.info("deleteAll()");
		BasicDBObject query = new BasicDBObject();
		executeQuery1(query);
	}
}
