package com.github.jlgrock.snp.apis.sample;

import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import org.jvnet.hk2.annotations.Contract;

/**
 * A simple sample query.
 */
@Contract
public interface SampleQuery {
    /**
     * The query that is to be executed against the sample database
     * @throws DataAccessException a data exception that indicates a connection problem
     */
    void query() throws DataAccessException;
}

