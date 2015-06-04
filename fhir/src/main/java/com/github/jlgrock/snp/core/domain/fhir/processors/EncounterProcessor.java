package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.logicgraph.FhirEncounterGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class EncounterProcessor extends AbstractFhirProcessor {

    private final Encounter encounter;

    public EncounterProcessor(final TerminologyStoreDI terminologyStoreDIIn, final Encounter encounterIn) {
        super(terminologyStoreDIIn);
        encounter = encounterIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        FhirEncounterGraphBuilder fhirEncounterGraphBuilder = new FhirEncounterGraphBuilder(getTerminologyStoreDI(), encounter);
        fhirEncounterGraphBuilder.create();
        return (LogicGraph) fhirEncounterGraphBuilder;
    }
}
