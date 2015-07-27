package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.index.SearchResult;
import org.ihtsdo.otf.tcc.api.blueprint.ComponentProperty;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Search the database for a description matching a term
 */
public class SearchByDescription extends AbstractQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchByDescription.class);

    @Override
    protected void run() throws IOException {
        setup();

        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        IndexerBI descriptionLookup = LookupService.get().getService(IndexerBI.class, "Description indexer");

        // Search the index for the description.  This will only go 5 levels deep
        int levelsToSearch = 5;
        List<SearchResult> bleedingDescriptionResult = descriptionLookup.query("bleeding", ComponentProperty.DESCRIPTION_TEXT, levelsToSearch);
        TerminologySnapshotDI statedTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());

        // Print the results
        if (!bleedingDescriptionResult.isEmpty()) {
            for (SearchResult result : bleedingDescriptionResult) {
                int bleedingDexcriptionNid = result.nid;
                int bleedingConceptNid = statedTermSnapshot.getConceptNidForNid(bleedingDexcriptionNid);
                ConceptChronicleBI bleedingConcept2 = termStore.getConcept(bleedingConceptNid);
                LOGGER.info("\nFound [3] nid: {} cNid: {}; ", bleedingDexcriptionNid, bleedingConceptNid, bleedingConcept2);
            }
        }

    }

    /**
     * Execute the Example
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        SearchByDescription searchByDescription = new SearchByDescription();
        searchByDescription.execute();
    }
}
