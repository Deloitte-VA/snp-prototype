package com.github.jlgrock.snp.classifier.examples;


import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.blueprint.ComponentProperty;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.ihtsdo.otf.tcc.model.index.service.SearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Search the database for a concept, using the Snomed Concept id (sctid) as an identifier
 */
public class SearchBySctId extends AbstractQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchBySctId.class);

    @Override
    protected void run() throws IOException {
        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        //IdentifierService idService = LookupService.getService(IdentifierService.class);
        IndexerBI snomedIdLookup = LookupService.get().getService(IndexerBI.class, "snomed id refex indexer");
        //LogicService logicService = LookupService.getService(LogicService.class);

        //TerminologySnapshotDI statedTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
        //TerminologySnapshotDI inferredTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

        Long sctId = 131148009L;

        // Search the index for the sctId.  This will only go 5 levels deep
        int levelsToSearch = 5;
        List<SearchResult> bleedingSctidResult =
                snomedIdLookup.query(Long.toString(sctId), ComponentProperty.STRING_EXTENSION_1, levelsToSearch);

        if (!bleedingSctidResult.isEmpty()) {
            for (SearchResult result : bleedingSctidResult) {
                int bleedingConceptNid = result.nid;
                LOGGER.info("\nFound [2] nid: {}", bleedingConceptNid);
                ConceptChronicleBI bleedingConcept2 = termStore.getConcept(bleedingConceptNid);
                LOGGER.info("Found [2]: {}", bleedingConcept2);
            }
        }
    }

    /**
     * Execute the Example
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        SearchBySctId searchBySctId = new SearchBySctId();
        searchBySctId.execute();
    }
}
