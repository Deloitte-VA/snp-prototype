package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class DiagnosticReportClassifier extends AbstractFhirClassifier {

    private final DiagnosticReport diagnosticReport;

    public DiagnosticReportClassifier(final TerminologyStoreDI terminologyStoreDIIn, final DiagnosticReport diagnosticReportIn) {
        super(terminologyStoreDIIn);
        diagnosticReport = diagnosticReportIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
