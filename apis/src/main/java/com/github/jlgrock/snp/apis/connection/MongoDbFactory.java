package com.github.jlgrock.snp.apis.connection;

import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.mongodb.DB;
import com.mongodb.WriteConcern;
import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface MongoDbFactory {

    public void destroy();

    public DB getDb() throws DataAccessException;

    public DB getDb(String name) throws DataAccessException;

    public void setWriteConcern(WriteConcern writeConcern);
}
