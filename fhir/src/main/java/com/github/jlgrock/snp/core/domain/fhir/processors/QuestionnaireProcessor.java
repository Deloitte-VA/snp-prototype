package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.Questionnaire;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class QuestionnaireProcessor extends AbstractFhirProcessor {

    private final Questionnaire questionnaire;

    public QuestionnaireProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Questionnaire questionnaireIn) {
        super(terminologyStoreDIIn);
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
