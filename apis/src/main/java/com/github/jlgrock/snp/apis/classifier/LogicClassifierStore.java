package com.github.jlgrock.snp.apis.classifier;

import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface LogicClassifierStore {
    /**
     * Start the expression service
     */
    void startExpressionService();

    /**
     * Stop the expression service
     */
    void stopExpressionService();

    /**
     * @return the indexer handle
     */
    public IndexerBI getIndexer();

    /**
     * @return the indexer handle
     */

}
