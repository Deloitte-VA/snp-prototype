package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
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

    IdentifierService getIdentifierService();

    IndexerBI getDescriptionLookupService();

    TaxonomyService getTaxonomyService();

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

}
