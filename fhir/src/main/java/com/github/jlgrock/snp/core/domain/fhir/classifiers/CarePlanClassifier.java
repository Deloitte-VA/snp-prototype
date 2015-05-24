package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.CarePlan;

/**
 *
 */
public class CarePlanClassifier extends AbstractFhirClassifier {

    private final CarePlan carePlan;

    public CarePlanClassifier(final CarePlan carePlanIn) {
        carePlan = carePlanIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
