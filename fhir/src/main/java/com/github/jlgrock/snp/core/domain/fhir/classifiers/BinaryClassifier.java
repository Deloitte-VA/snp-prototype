package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.model.Binary;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class BinaryClassifier extends AbstractFhirClassifier {

    private final Binary binary;

    public BinaryClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Binary binaryIn) {
        super(terminologyStoreDIIn);
        binary = binaryIn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

}
