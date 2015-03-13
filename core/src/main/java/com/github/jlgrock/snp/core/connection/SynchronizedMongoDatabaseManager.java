package com.github.jlgrock.snp.core.connection;

import com.mongodb.DB;
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

    boolean synchronizedWithTransaction = true;

    /**
     * Created to allow for locking.
     */
    private final Object lock = new Object();

    /**
     * The concurrent hashmap that will allow you to keep track of the accessed databases, by name.
     */
    private final Map<String, DB> collectionMap = new ConcurrentHashMap<>();

    @Override
    public void addDb(final String key, final DB session) {
        collectionMap.put(key, session);
    }

    @Override
    public DB removeDB(final String dbName) {
        return collectionMap.remove(dbName);
    }

    @Override
    public boolean containsDB(final DB session) {
        return collectionMap.containsValue(session);
    }

    @Override
    public boolean containsDB(final String key) {
        return collectionMap.containsKey(key);
    }

    @Override
    public boolean isEmpty() {
        return collectionMap.isEmpty();
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
    public void setSynchronizedWithTransaction(boolean value) {
        synchronized (lock) {
            synchronizedWithTransaction = value;
        }
    }
}
