package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Encounter;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class EncounterClassifier extends AbstractFhirClassifier {

    private final Encounter encounter;

    public EncounterClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Encounter encounterIn) {
        super(terminologyStoreDIIn);
        encounter = encounterIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
