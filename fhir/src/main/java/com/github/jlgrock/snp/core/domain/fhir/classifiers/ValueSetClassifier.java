package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.ValueSet;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class ValueSetClassifier extends AbstractFhirClassifier {

    private final ValueSet valueSet;

    public ValueSetClassifier(final TerminologyStoreDI terminologyStoreDIIn, final ValueSet valueSetIn) {
        super(terminologyStoreDIIn);
        valueSet = valueSetIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }
}
