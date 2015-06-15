package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.logicgraph.FhirEncounterGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import gov.vha.isaac.logic.LogicGraph;

/**
 *
 */
public class EncounterProcessor extends AbstractFhirProcessor {

    private final Encounter encounter;

    public EncounterProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Encounter encounterIn) {
        super(logicGraphClassifierIn);
        encounter = encounterIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        FhirEncounterGraphBuilder fhirEncounterGraphBuilder = new FhirEncounterGraphBuilder(getLogicGraphClassifier(), encounter);
        LogicGraph logicGraph = fhirEncounterGraphBuilder.build();
        return logicGraph;
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}
}
