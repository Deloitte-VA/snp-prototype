package com.github.jlgrock.snp.core.connection;

import com.github.jlgrock.snp.apis.connection.MongoDatabaseManager;
import com.mongodb.client.MongoDatabase;
import org.jvnet.hk2.annotations.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A Manager that keeps the database connections that have been initialized in memory.
 * This should save initialization costs as well as allow for more complicated
 * synchronization mechanisms.
 */
@Service
public class SynchronizedMongoDatabaseManager implements MongoDatabaseManager {

    /**
     * whether or not the manager is synchronized
     */
    private volatile boolean synchronizedWithTransaction = false;

    /**
     * The concurrent hashmap that will allow you to keep track of the accessed databases, by name.
     */
    private final Map<String, MongoDatabase> collectionMap = new ConcurrentHashMap<>();

    @Override
    public void addDatabase(final String key, final MongoDatabase session) {
        collectionMap.put(key, session);
    }

    @Override
    public MongoDatabase removeDatabase(final String dbName) {
        return collectionMap.remove(dbName);
    }

    @Override
    public boolean containsDatabase(final MongoDatabase session) {
        return collectionMap.containsValue(session);
    }

    @Override
    public boolean containsDatabase(final String key) {
        return collectionMap.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return collectionMap.isEmpty();
    }

    @Override
    public MongoDatabase getDatabase(final String key) {
        return collectionMap.get(key);
    }

    /**
     * Whether or not this is currently marked as synchronized
     *
     * @return true if it has been synchronized, false otherwise
     */
    public boolean isSynchronizedWithTransaction() {
        return synchronizedWithTransaction;
    }

    /**
     * Set the synchronized flag, done in a thread safe way.
     *
     * @param value the value to set it to
     */
    public void setSynchronizedWithTransaction(final boolean value) {
        synchronizedWithTransaction = value;
    }
}
