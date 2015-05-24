package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Questionnaire;

/**
 *
 */
public class QuestionnaireClassifier extends AbstractFhirClassifier {

    private final Questionnaire questionnaire;

    public QuestionnaireClassifier(final Questionnaire questionnaireIn) {
        questionnaire = questionnaireIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
