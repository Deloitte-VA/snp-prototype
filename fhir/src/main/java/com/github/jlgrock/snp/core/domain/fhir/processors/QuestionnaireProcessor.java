package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Questionnaire;
import gov.vha.isaac.logic.LogicGraph;

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
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
