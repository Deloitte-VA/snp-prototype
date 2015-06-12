package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.blueprint.ComponentProperty;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.ihtsdo.otf.tcc.model.index.service.SearchResult;

import java.io.IOException;
import java.util.List;

public class SearchByDescription extends AbstractQuery {
    protected void search() throws IOException {
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
                System.out.println("\nFound [3] nid: " + bleedingDexcriptionNid + " cNid: " + bleedingConceptNid +
                        "; " + bleedingConcept2);
            }
        }

    }
    public static void main(String[] args) {
        SearchByDescription searchByDescription = new SearchByDescription();
        searchByDescription.execute();
    }
}
