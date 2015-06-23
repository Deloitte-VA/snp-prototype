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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;

/**
 * Search the database for a concept, using the uuid as an identifier
 */
public class SearchByUUID extends AbstractQuery {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchByUUID.class);

    @Override
    protected void run() throws IOException {
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
        LOGGER.info("\nFound [1] nid: {}", bleedingConcept1.getNid());
        LOGGER.info("Found [1] concept sequence: {}", idService.getConceptSequence(bleedingConcept1.getNid()));
        LOGGER.info("Found [1]: {}\n {}", bleedingConcept1, bleedingConcept1.toLongString());

        //Print the results
        LogicGraph lg1 = logicService.createLogicGraph((ConceptVersion) statedTermSnapshot.getConceptVersion(bleedingConcept1.getConceptNid()));
        LOGGER.info("Stated logic graph:  {}", lg1);
        LogicGraph lg2 = logicService.createLogicGraph((ConceptVersion) inferredTermSnapshot.getConceptVersion(bleedingConcept1.getConceptNid()));
        LOGGER.info("Inferred logic graph: {}", lg2);
    }

    /**
     * Execute the Example
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        SearchByUUID searchByUUID = new SearchByUUID();
        searchByUUID.execute();
    }

}
