package com.github.jlgrock.snp.apis.classifier;

import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 *
 */
@Contract
public interface LogicGraphClassifierQuery {

    /**
     * Query for the nids of matching classifier
     * @param id the query uuids
     * @return the list of matching Nids
     */
    List<Integer> query(String id);
}
