package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Alert;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class AlertClassifier extends AbstractFhirClassifier {

    private final Alert alert;

    public AlertClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Alert alertIn) {
        super(terminologyStoreDIIn);
        alert = alertIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
