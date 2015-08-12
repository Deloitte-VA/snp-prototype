package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.api.classifier.ClassifierService;
import gov.vha.isaac.ochre.api.coordinate.EditCoordinate;
import gov.vha.isaac.ochre.api.coordinate.StampCoordinate;
import gov.vha.isaac.ochre.api.logic.LogicService;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.jvnet.hk2.annotations.Contract;

/**
 * The classifier store, which stores the data from the classifier.
 */
@Contract
public interface ClassifierStorage {
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

    /**
     * @return the service that is used to find concept sequences
     */
    TaxonomyService getTaxonomyService();

    /**
     * @return get the latest view coordinate.  This is used for everything in the system for now
     */
    ViewCoordinate getViewCoordinate();

    /**
     * @return the latest stamp coordinate.  This is used for everything in the system for now
     */
    StampCoordinate getStampCoordinate();

    /**
     * @return the sequence that identifies the inferred assemblage
     */
    int getInferredAssemblageSequence();

    /**
     * @return the classifier service using the latest STAMP
     */
    ClassifierService getClassifierService();

    /**
     * @return the Edit coordinates required for use in building concepts
     */
    EditCoordinate getSolorOverlay();

}
