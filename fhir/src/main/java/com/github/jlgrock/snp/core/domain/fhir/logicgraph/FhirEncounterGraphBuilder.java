package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.core.domain.fhir.Encounter;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.RootNode;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class FhirEncounterGraphBuilder extends AbstractFhirLogicGraphBuilder {
    final Encounter encounter;

    @Override
    public void create() {
        //Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();

        AbstractNode node = processEncounter(encounter);
        root.addChildren(SufficientSet(node));
    }

    public FhirEncounterGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn, final Encounter encounterIn) {
        super(terminologyStoreDIIn);
        encounter = encounterIn;
    }

    protected AbstractNode processEncounter(final Encounter encounter) {
//        List<Encounter> encounters = condition.getEncounter();
        //TODO
        return null;
    }
}
