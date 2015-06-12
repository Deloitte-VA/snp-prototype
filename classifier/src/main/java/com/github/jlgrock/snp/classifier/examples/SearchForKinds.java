package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.collections.ConceptSequenceSet;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

import java.io.IOException;

/**
 *
 */
public class SearchForKinds extends AbstractQuery {

    @Override
    protected void search() throws IOException {
        TaxonomyService taxonomy = LookupService.getService(TaxonomyService.class);
        LogicService logicService = LookupService.getService(LogicService.class);
        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);

        // get the logic graph for "bleeding of abdominal wall"
        LogicGraph abdominalWallBleedingDef = new CreateLogicExpression().execute();

        // get the concept sequence for "bleeding of abdominal wall"
        int newSequence = logicService.getConceptSequenceForExpression(abdominalWallBleedingDef,
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());
        System.out.println("sequence number: " + newSequence);

        //Create a set out of the sequence number(s)
        ConceptSequenceSet newConcepts = ConceptSequenceSet.of(newSequence);
        System.out.println("new concepts: " + newConcepts);

        logicService.fullClassification(StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());

        System.out.println("Completed Full Classification");

        //TODO no idea...
        logicService.incrementalClassification(StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay(), newConcepts);

//        // find the uuid for bleeding
//        UUID bleedingSnomedUuid = UuidT3Generator.fromSNOMED(131148009L);
//        ConceptChronicleBI bleedingConcept1 = termStore.getConcept(bleedingSnomedUuid);




//        SequenceSet kindOfBleedingSequences = taxonomy.getKindOfSequenceSet(bleedingConcept1.getNid(), ViewCoordinates.getDevelopmentInferredLatest());
//        System.out.println("\nHas " + kindOfBleedingSequences.size() + " kinds.");
//
//        if (kindOfBleedingSequences.contains(newSequence)) {
//            System.out.println("Kind-of set includes new concept " + newSequence);
//        } else {
//            System.out.println("Error: kind-of set does not include new concept " + newSequence);
//        }
    }
    public static void main(String[] args) {
        SearchForKinds searchForKinds = new SearchForKinds();
        searchForKinds.execute();
    }
}
