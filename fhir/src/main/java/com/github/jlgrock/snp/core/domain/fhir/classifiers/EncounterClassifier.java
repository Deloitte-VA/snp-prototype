package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.core.domain.fhir.Encounter;
import com.github.jlgrock.snp.core.domain.fhir.logicgraph.FhirEncounterGraphBuilder;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicGraphBuilder;
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
    protected LogicGraph getLogicGraph() {
        FhirEncounterGraphBuilder fhirEncounterGraphBuilder = new FhirEncounterGraphBuilder(getTerminologyStoreDI(), encounter);
        fhirEncounterGraphBuilder.create();
        return (LogicGraph) fhirEncounterGraphBuilder;
    }
}
