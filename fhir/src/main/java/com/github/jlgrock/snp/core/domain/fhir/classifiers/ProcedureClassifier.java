package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Procedure;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ProcedureClassifier extends AbstractFhirClassifier {

    private final Procedure procedure;

    public ProcedureClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Procedure procedureIn) {
        super(terminologyStoreDIIn);
        procedure = procedureIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
