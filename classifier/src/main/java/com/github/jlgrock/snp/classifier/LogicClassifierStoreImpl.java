package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.connection.configuration.FileConfiguration;
import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.api.classifier.ClassifierService;
import gov.vha.isaac.ochre.api.component.concept.ConceptService;
import gov.vha.isaac.ochre.api.constants.Constants;
import gov.vha.isaac.ochre.api.coordinate.EditCoordinate;
import gov.vha.isaac.ochre.api.coordinate.LogicCoordinate;
import gov.vha.isaac.ochre.api.coordinate.StampCoordinate;
import gov.vha.isaac.ochre.api.logic.LogicService;
import org.glassfish.hk2.runlevel.RunLevelController;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

/**
 * The default implementation of the classifier store, this stores data in ochre and lucene.
 * Because the objects retrieved here are powerful, control to this object is restricted to the
 * package.
 */
@Service
@Singleton
class LogicClassifierStoreImpl implements LogicClassifierStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogicClassifierStoreImpl.class);

    private final FileConfiguration fileConfiguration;

    /**
     * Constructor that will create and start the expression service.
     * @param fileConfigurationIn the configuration that will be used for the expression service
     */
    @Inject
    public LogicClassifierStoreImpl(final FileConfiguration fileConfigurationIn) {
        LOGGER.info("Starting Expression Service...");
        fileConfiguration = fileConfigurationIn;
        startExpressionService();
        int conceptCnt = LookupService.getService(ConceptService.class).getConceptCount();
        if (conceptCnt == 0) {
            LOGGER.warn("No concepts found.  An empty database is being indexed.  This is either a new setup or an incorrect property has been set");
        } else {
            LOGGER.info("After startup, the number of concepts loaded is {}", conceptCnt);
        }
        runFullClassification();
    }

    /**
     * Classification consists of: converting the logic graph to axioms in memory, running the classification
     * algorithms over the axioms, retrieving the results, determining what changed, and then write back to the
     * logic graph assemblage. Running a full classification will likely take several minutes.
     */
    private void runFullClassification() {
        getClassifierService().classify();
    }

    @Override
    public ClassifierService getClassifierService() {
        return getLogicService().getClassifierService(
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());
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
    public LogicService getLogicService() {
        return LookupService.getService(LogicService.class);
    }

    @Override
    public IdentifierService getIdentifierService() {
        return LookupService.getService(IdentifierService.class);
    }

    @Override
    public TaxonomyService getTaxonomyService() {
        return LookupService.getService(TaxonomyService.class);
    }

    @Override
    public void stopExpressionService() {
        LookupService.shutdownIsaac();
        LOGGER.info("Shutting down Expression service...");
    }

    @Override
    public ViewCoordinate getViewCoordinate() {
        ViewCoordinate viewCoordinate = null;
        try {
            viewCoordinate = ViewCoordinates.getDevelopmentInferredLatest();
        } catch(IOException ioe) {
            LOGGER.error("Unable to get latest inferred view coordinates", ioe);
        }
        return viewCoordinate;
    }

    @Override
    public StampCoordinate getStampCoordinate() {
        return StampCoordinates.getDevelopmentLatest();
    }

    @Override
    public int getInferredAssemblageSequence() {
        LogicCoordinate logicCoordinate = LogicCoordinates.getStandardElProfile();
        return logicCoordinate.getInferredAssemblageSequence();
    }

    @Override
    public EditCoordinate getSolorOverlay() {
        return EditCoordinates.getDefaultUserSolorOverlay();
    }
}
