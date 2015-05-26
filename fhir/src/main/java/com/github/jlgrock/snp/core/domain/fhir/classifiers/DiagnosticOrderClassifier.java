package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.DiagnosticOrder;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiagnosticOrderClassifier extends AbstractFhirClassifier {

    private final DiagnosticOrder diagnosticOrder;

    public DiagnosticOrderClassifier(final TerminologyStoreDI terminologyStoreDIIn, final DiagnosticOrder diagnosticOrderIn) {
        super(terminologyStoreDIIn);
        diagnosticOrder = diagnosticOrderIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
