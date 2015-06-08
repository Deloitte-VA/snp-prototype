package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.connection.configuration.FileConfiguration;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.api.constants.Constants;
import org.glassfish.hk2.runlevel.RunLevelController;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 */
@Service
@Singleton
public class LogicClassifierStoreImpl implements LogicClassifierStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogicClassifierStoreImpl.class);


//  TerminologySnapshotDI statedTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
//  TerminologySnapshotDI inferredTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

    final FileConfiguration fileConfiguration;

    @Inject
    public LogicClassifierStoreImpl(final FileConfiguration fileConfigurationIn) {
        LOGGER.info("Starting Expression Service...");
        fileConfiguration = fileConfigurationIn;
        startExpressionService();
    }

    @Override
    public void startExpressionService() {
        LOGGER.trace("RunLevelController runLevel: {}", LookupService.getService(RunLevelController.class).getCurrentRunLevel());

        if(!LookupService.isIsaacStarted()) {
            LOGGER.info("Setting System properties for Expression Service startup...");
            System.setProperty(Constants.CHRONICLE_COLLECTIONS_ROOT_LOCATION_PROPERTY, fileConfiguration.chronicleLocation().toString());
            System.setProperty(Constants.SEARCH_ROOT_LOCATION_PROPERTY, fileConfiguration.luceneLocation().toString());

            LookupService.startupIsaac();
            LOGGER.info("Expression Service is now up.");
        } else {
            LOGGER.warn("Expression Service is already up and running.");
        }
    }

    @Override
    public IndexerBI getIndexer() {
        return LookupService.getService(IndexerBI.class, "snomed id refex indexer");
    }

    @Override
    public TerminologyStoreDI getTerminologyStore() {
        return LookupService.getService(TerminologyStoreDI.class);
    }

    @Override
    public IdentifierService getIdentifierService() {
        return LookupService.getService(IdentifierService.class);
    }

    @Override
    public IndexerBI getDescriptionLookupService() {
        return LookupService.getService(IndexerBI.class, "Description indexer");
    }

    @Override
    public TaxonomyService getTaxonomyService() {
        return LookupService.getService(TaxonomyService.class);
    }

    @Override
    public void stopExpressionService() {
        LookupService.shutdownIsaac();
        LOGGER.info("System down...");
    }
}
