package com.github.jlgrock.snp.mockclassifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.api.logic.LogicService;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;

/**
 *
 */
public class LogicClassifierStoreImpl implements LogicClassifierStore {
    @Override
    public void startExpressionService() {

    }

    @Override
    public void stopExpressionService() {

    }

    @Override
    public IndexerBI getIndexer() {
        return null;
    }

    @Override
    public TerminologyStoreDI getTerminologyStore() {
        return null;
    }

    @Override
    public LogicService getLogicService() {
        return null;
    }

    @Override
    public IdentifierService getIdentifierService() {
        return null;
    }

    @Override
    public TaxonomyService getTaxonomyService() {
        return null;
    }

    @Override
    public ViewCoordinate getViewCoordinate() {
        return null;
    }
}
