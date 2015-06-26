package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Questionnaire;

/**
 *
 */
public class QuestionnaireProcessor extends AbstractFhirProcessor {

    private final Questionnaire questionnaire;

    public QuestionnaireProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Questionnaire questionnaireIn) {
        super(logicGraphClassifierIn);
        questionnaire = questionnaireIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
