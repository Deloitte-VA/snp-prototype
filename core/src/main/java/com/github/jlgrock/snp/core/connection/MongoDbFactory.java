package com.github.jlgrock.snp.core.connection;

import com.github.jlgrock.snp.core.exceptions.DataAccessException;
import com.mongodb.DB;
import com.mongodb.WriteConcern;

/**
 *
 */
public interface MongoDbFactory {

    public void destroy();

    public DB getDb() throws DataAccessException;

    public DB getDb(String name) throws DataAccessException;

    public void setWriteConcern(WriteConcern writeConcern);
}
