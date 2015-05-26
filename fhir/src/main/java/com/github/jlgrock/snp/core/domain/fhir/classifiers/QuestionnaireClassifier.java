package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Questionnaire;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class QuestionnaireClassifier extends AbstractFhirClassifier {

    private final Questionnaire questionnaire;

    public QuestionnaireClassifier(final TerminologyStoreDI terminologyStoreDIIn, final Questionnaire questionnaireIn) {
        super(terminologyStoreDIIn);
        questionnaire = questionnaireIn;
    }

    @Override
    public void classify() {
        throw new UnsupportedOperationException();
    }
}
