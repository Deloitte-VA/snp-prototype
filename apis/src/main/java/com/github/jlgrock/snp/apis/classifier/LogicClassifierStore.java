package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.ochre.api.IdentifierService;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.jvnet.hk2.annotations.Contract;

/**
 * The classifier store, which stores the data from the classifier.
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
    IndexerBI getIndexer();

    /**
     * @return the terminology store handle
     */
    TerminologyStoreDI getTerminologyStore();

    /**
     * @return the logic service
     */
    LogicService getLogicService();

    /**
     * @return the service that is used to find concept sequences
     */
    IdentifierService getIdentifierService();
}
