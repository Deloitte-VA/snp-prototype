package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.ihtsdo.otf.tcc.model.cc.concept.ConceptVersion;

import java.io.IOException;
import java.util.UUID;

/**
 *
 */
public class SearchByUUID extends AbstractQuery {
    @Override
    protected void search() throws IOException {
        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        IdentifierService idService = LookupService.getService(IdentifierService.class);
        LogicService logicService = LookupService.getService(LogicService.class);

        TerminologySnapshotDI statedTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
        TerminologySnapshotDI inferredTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

        Long sctId = 131148009L;

        // Convert the sctId into a UUID
        UUID bleedingSnomedUuid = UuidT3Generator.fromSNOMED(sctId);

        // Get the concept directly from the Terminology Store
        ConceptChronicleBI bleedingConcept1 = termStore.getConcept(bleedingSnomedUuid);
        System.out.println("\nFound [1] nid: " + bleedingConcept1.getNid());
        System.out.println("Found [1] concept sequence: " + idService.getConceptSequence(bleedingConcept1.getNid()));
        System.out.println("Found [1]: " + bleedingConcept1 + "\n " + bleedingConcept1.toLongString());

        //Print the results
        LogicGraph lg1 = logicService.createLogicGraph((ConceptVersion) statedTermSnapshot.getConceptVersion(bleedingConcept1.getConceptNid()));
        System.out.println("Stated logic graph:  " + lg1);
        LogicGraph lg2 = logicService.createLogicGraph((ConceptVersion) inferredTermSnapshot.getConceptVersion(bleedingConcept1.getConceptNid()));
        System.out.println("Inferred logic graph:  " + lg2);
    }

    public static void main(String[] args) {
        SearchByUUID searchByUUID = new SearchByUUID();
        searchByUUID.execute();
    }

}
