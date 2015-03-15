package com.github.jlgrock.snp.core.sample;

import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface SampleQuery {
    public void query() throws DataAccessException;
}
