package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.classifier.ClassifierService;
import gov.vha.isaac.ochre.api.logic.LogicService;
import gov.vha.isaac.ochre.util.UuidT3Generator;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
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

        ClassifierService classifierService = logicService.getClassifierService(
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());

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
