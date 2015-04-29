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
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
     * @param dbObjectin Data Base Object is an input parameter used in this method
     * @return the method returns a Serializable S object as output
     */
    protected abstract S convertToDomainObject(final Document dbObjectin);

    /**
     * Changes an S object into a DBObject
     *
     * @param s Serializable object is used as an input parameter for this
     *          method
     * @return the method returns an object of type DBObject
     */
    protected abstract Document convertToDBObject(final S s);

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
     *                         mongoDbFactoryIn by the constructor
     */
    protected AbstractRepositoryImpl(final MongoDbFactory mongoDbFactoryIn) {
        mongoDbFactory = mongoDbFactoryIn;
    }

    /**
     * @return method will return a string
     */
    protected abstract String getCollectionName();

    /**
     * Performs a query, and transforms the results to a list, ignoring the cast exception.
     *
     * @param query the query to execute, assumes multiple results are expected
     * @return a list of the objects
     */
    @SuppressWarnings("unchecked")
    protected List<S> executeQueryAndTransformResults(final Document query) {
        List<S> eList = new ArrayList<>();
        dBCollection().find(query).forEach(
                (Consumer<Document>) this::convertToDomainObject
        );
        return eList;
    }

    /**
     * @return method returns a DBCollection object which contains a collection
     * of data from a MongoDB instance.
     */
    protected MongoCollection dBCollection() {
        MongoDatabase db = null;
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
        MongoCollection dbCollection = db.getCollection(collectionName);

        return dbCollection;
    }

    private void deleteByQuery(final Document query) {
        dBCollection().deleteMany(query);
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
        dBCollection().insertOne(convertToDBObject(entity));
        return entity;
    }

    @Override
    public <S1 extends S> Iterable<S1> save(final Iterable<S1> entities) {
        MongoCollection<Document> dbCollection = dBCollection();
        for (S entity : entities) {
            Document query = new Document() {{
                id:
                entity.getId();
            }};
            Document update = convertToDBObject(entity);
            dbCollection.updateOne(query, update);
        }
        return entities;
    }

    @Override
    public S findOneById(final T id) {
        LOGGER.info("find(id=" + id + ")");
        Document query = new Document() {{
            put("_id", id);

        }};
        FindIterable<Document> iterable = dBCollection().find(query).limit(1);
        return convertToDomainObject(iterable.first());
    }

    @Override
    public boolean existsById(final T id) {
        LOGGER.info("exists(id=" + id + ")");
        S obj = findOneById(id);
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Override
    public Iterable<S> findAll() {
        LOGGER.info("findAll()");
        return executeQueryAndTransformResults(new Document());
    }

    @Override
    public Iterable<S> findAllById(final Iterable<T> ids) {
        LOGGER.info("findall(ids=" + Lists.newArrayList(ids).stream().map(id -> id.toString()).collect(Collectors.joining(", ")) + ")");
        List<S> sList = new ArrayList<>();
        Document query = new Document() {{
            put("_id", new BasicDBObject() {{
                put("$in", ids);
            }});
        }};

        return dBCollection().find(query).into(sList);
    }

    @Override
    public long count() {
        return dBCollection().count();
    }

    @Override
    public void delete(final S entity) {
        LOGGER.info("deleteById(entity=" + entity + ")");
        dBCollection().findOneAndDelete(convertToDBObject(entity));
    }

    @Override
    public void deleteById(final T id) {
        LOGGER.info("deleteById(id=" + id + ")");
        Document query = new Document() {{
            put("_id", id);
        }};
        deleteByQuery(query);
    }

    @Override
    public void delete(final Iterable<? extends S> entities) {
        LOGGER.info("delete(ids=" + Lists.newArrayList(entities).stream().map(id -> id.toString()).collect(Collectors.joining(", ")) + ")");
        Document query = new Document() {{
            put("_id", new Document() {{
                put("$in", entities);
            }});
        }};
        deleteByQuery(query);
    }

    @Override
    public void deleteAll() {
        LOGGER.info("deleteAll()");
        deleteByQuery(new Document());
    }
}
