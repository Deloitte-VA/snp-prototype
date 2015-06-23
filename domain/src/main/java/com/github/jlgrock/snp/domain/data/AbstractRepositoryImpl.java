package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.apis.domain.MongoDomainObject;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.google.common.collect.Lists;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
        LOGGER.trace("executeQueryAndTransformResults(query={})", query);
        List<S> eList = new ArrayList<>();
        if (query == null) {
            return eList;
        }

        FindIterable<Document> newCollection = dBCollection().find(query);

        for (Document d : newCollection) {
            eList.add(convertToDomainObject(d));
        }

        return eList;
    }

    /**
     * @return method returns a DBCollection object which contains a collection
     * of data from a MongoDB instance.
     */
    protected MongoCollection dBCollection() {
        LOGGER.trace("dbCollection()");
        MongoDatabase db = null;
        try {
            db = mongoDbFactory.db();
        } catch (DataAccessException e) {
            LOGGER.error("Could not get access to the data.", e);
        }
        String collectionName = getCollectionName();
        if (collectionName == null) {
            LOGGER.error(
                    "Collection name has not been set on class {}, code will fail until this is remedied",
                    this.getClass().getSimpleName() + "");
            return null;
        }
        assert db != null;
        return db.getCollection(collectionName);
    }

    /**
     * Delete all documents based on a query
     *
     * @param query delete using this query
     */
    private void deleteByQuery(final Document query) {
        LOGGER.trace("deleteByQuery(query={})", query);
        if (query == null) {
            LOGGER.error("Document parameter was null for the deleteByQuery method.");
        }
        dBCollection().deleteMany(query);
    }

    @Override
    public Iterable<S> findAll(final Sort sort) {
        LOGGER.trace("findAll(sort={})", sort);
        throw new UnsupportedOperationException("Method is not currently being utilized.");
    }

    @Override
    public Page<S> findAll(final Pageable pageable) {
        LOGGER.trace("findAll(pageable={})", pageable);
        throw new UnsupportedOperationException("Method is not currently being utilized.");
    }

    @Override
    public <R extends S> S save(final R entity) {
        LOGGER.trace("save(entity={})", entity);
        if (entity == null) {
            LOGGER.error("Entity parameter for save method is null, therefore nothing can be saved or updated in the database.");
            return null;
        }

        dBCollection().updateOne(createIdDocumentFromEntity(entity), convertToSetDocument(convertToDBObject(entity)), updateOptions());
        return entity;
    }

    /**
     * Convert a document into a set statement, based on saving the entity using an upsert
     *
     * @param document the document to update
     * @return the set document
     */
    protected Document convertToSetDocument(final Document document) {
        Document updateDoc = new Document();
        updateDoc.putAll(document);
        updateDoc.remove(SharedTags.ID_TAG);
        Document newDocument = new Document();
        newDocument.put("$set", updateDoc);
        newDocument.put("$setOnInsert", createIdDocument((T) document.get(SharedTags.ID_TAG)));
        return newDocument;
    }

    /**
     * @return The upsert setting
     */
    protected UpdateOptions updateOptions() {
        UpdateOptions updateOptions = new UpdateOptions();
        updateOptions.upsert(true);
        return updateOptions;
    }

    @Override
    public <R extends S> Iterable<R> save(final Iterable<R> entities) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("save(entities={}",
                    Lists.newArrayList(entities)
                            .stream()
                            .map(entity -> entity.toString())
                            .collect(Collectors.joining(", ")));
        }
        if (entities == null) {
            LOGGER.error("Entities parameter for save method is null, therefore nothing can be saved or updated in the database.");
            return null;
        }
        entities.forEach(this::save);
        return entities;
    }

    @Override
    public S findOneById(final T id) {
        LOGGER.trace("findOneByID(id={})", id);
        if (id == null) {
            LOGGER.error("Id parameter for findOneById method is null, therefore Domain Object cannot be found.");
            return null;
        }
        FindIterable<Document> iterable = dBCollection().find(createIdDocument(id)).limit(1);
        Document first = iterable.first();
        return convertToDomainObject(first);

    }

    @Override
    public boolean existsById(final T id) {
        LOGGER.trace("exists(id={})", id);
        if (id == null) {
            LOGGER.error("Id parameter for existsById method is null, therefore Domain Object does not exist.");
            return false;
        }
        S obj = findOneById(id);
        return obj != null;
    }

    @Override
    public Iterable<S> findAll() {
        LOGGER.trace("findAll()");
        return executeQueryAndTransformResults(new Document());
    }

    @Override
    public Iterable<S> findAllById(final Iterable<T> ids) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("findAllById(ids={}",
                    Lists.newArrayList(ids)
                            .stream()
                            .map(id -> id.toString())
                            .collect(Collectors.joining(", ")));
        }
        List<S> sList = new ArrayList<>();
        if (ids == null) {
            return sList;
        }
        return dBCollection().find(createIdDocument(ids)).into(sList);
    }

    @Override
    public long count() {
        LOGGER.trace("count()");
        return dBCollection().count();
    }

    @Override
    public void delete(final S entity) {
        LOGGER.trace("deleteById(entity={})", entity);
        if (entity == null) {
            LOGGER.error("Entity parameter for delete method is null, therefore no values were removed from the database.");
        }
        dBCollection().findOneAndDelete(createIdDocumentFromEntity(entity));
    }

    @Override
    public void deleteById(final T id) {
        LOGGER.trace("deleteById(id={})", id);
        if (id == null) {
            LOGGER.error("Id parameter for deleteById method is null, therefore no values were removed from the database.");
        }
        deleteByQuery(createIdDocument(id));
    }

    @Override
    public void delete(final Iterable<? extends S> entities) {
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("delete(entities={}",
                    Lists.newArrayList(entities)
                            .stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", ")));
        }
        if (entities == null) {
            LOGGER.error("Entities parameter for delete method is null, therefore no values were removed from the database.");
            return;
        }
        deleteByQuery(createIdDocumentFromEntities(entities));
    }

    @Override
    public void deleteAll() {
        LOGGER.trace("deleteAll()");
        deleteByQuery(new Document());
    }

    /**
     * Create a Document that will match any of the ids
     *
     * @param entities the entities to search for
     * @return the document created
     */
    protected Document createIdDocumentFromEntities(final Iterable<? extends S> entities) {
        if (entities == null) {
            LOGGER.error("cannot create empty id document");
            return null;
        }
        ArrayList<T> ids = new ArrayList<>();
        for (S entity : entities) {
            ids.add(entity.getId());
        }
        return createIdDocument(ids);
    }

    /**
     * Create a Document that will match any of the ids
     *
     * @param ids the ids to search for
     * @return the document created
     */
    protected Document createIdDocument(final Iterable<T> ids) {
        if (ids == null) {
            LOGGER.error("cannot create empty id document");
            return null;
        }
        Document d = new Document();
        Document sub = new Document();
        sub.put("$in", ids);
        d.put("_id", sub);
        return d;
    }

    /**
     * Create a Document that will match the id
     *
     * @param entity the entity to search for
     * @return the document created
     */
    protected Document createIdDocumentFromEntity(final S entity) {
        if (entity == null) {
            LOGGER.error("cannot create empty id document");
            return null;
        }
        return createIdDocument(entity.getId());
    }

    /**
     * Create a Document that will match the id
     *
     * @param id the id to search for
     * @return the document created
     */
    protected Document createIdDocument(final T id) {
        if (id == null) {
            LOGGER.error("cannot create empty id document");
            return null;
        }
        Document d = new Document();
        d.put("_id", id);
        return d;
    }
}
