package com.github.jlgrock.snp.apis.connection;

import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoDatabase;
import org.jvnet.hk2.annotations.Contract;

/**
 * The Factory for creating mongoDB instances
 */
@Contract
public interface MongoDbFactory {

    /**
     * Destroy the connection.
     */
    void destroy();

    /**
     * Returns the default database
     *
     * @return get the default Database
     * @throws DataAccessException if the default database does not exist or a connection cannot be made
     */
    MongoDatabase db() throws DataAccessException;

    /**
     * Returns the database with the name indicated
     *
     * @param name the name of the database to get
     * @return get the Database with the name specified
     * @throws DataAccessException if the default database does not exist or a connection cannot be made
     */
    MongoDatabase db(String name) throws DataAccessException;

    /**
     * Set the Write concern of the connection
     * @param writeConcern the write concern to use
     */
    void setWriteConcern(WriteConcern writeConcern);

    /**
     * @return the current setting for the write concern
     */
    WriteConcern getWriteConcern();

}

