package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.constants.Constants;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

/**
 *
 */
@Service
@Singleton
public class LogicClassifierStoreImpl implements LogicClassifierStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogicClassifierStoreImpl.class);

    public LogicClassifierStoreImpl() {
        LOGGER.info("Starting Expression Service...");
        startExpressionService();
    }

    @Override
    public void startExpressionService() {

        if(LookupService.isIsaacStarted()) {
            LOGGER.info("Setting System properties...");
            System.setProperty(Constants.CHRONICLE_COLLECTIONS_ROOT_LOCATION_PROPERTY, "target/data/object-chronicles");
            System.setProperty(Constants.SEARCH_ROOT_LOCATION_PROPERTY, "target/data/search");

            LookupService.startupIsaac();
            LOGGER.info("Expression Service is up.");
        } else {
            LOGGER.warn("Expression Service is already up and running.");
        }
    }

    @Override
    public IndexerBI getIndexer() {
        return LookupService.get().getService(IndexerBI.class, "snomed id refex indexer");
    }

    @Override
    public TerminologyStoreDI getTerminologyStore() {
        return LookupService.get().getService(TerminologyStoreDI.class);
    }

    @Override
    public void stopExpressionService() {
        LookupService.shutdownIsaac();
        LOGGER.info("System down...");
    }
}
