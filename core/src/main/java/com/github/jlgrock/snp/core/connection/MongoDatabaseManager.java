package com.github.jlgrock.snp.core.connection;

import com.mongodb.DB;

/**
 * Defines a class that will be able to index open connections to many MongoDB instances.
 */
public interface MongoDatabaseManager {
    /**
     * Index a created database session.
     *
     * @param key the name of the database
     * @param session the database session
     */
    void addDb(String key, DB session);

    /**
     * Unindex a database that is no longer used.
     *
     * @param dbName the name of the database to un-index.
     * @return the database that matches the name, or null if it doesn't exist
     */
    DB removeDB(String dbName);

    /**
     * Determine whether or not the DB has been indexed.
     * @param session the db to check for
     * @return
     */
    boolean containsDB(DB session);

    /**
     * Determine whether or not the DB has been indexed.
     * @param key the db to check for
     * @return
     */
    boolean containsDB(String key);

    /**
     * Whether or not this index has been initialized or not
     *
     * @return true if it is empty, false otherwise
     */
    boolean isEmpty();
}
