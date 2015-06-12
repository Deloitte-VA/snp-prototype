package com.github.jlgrock.snp.classifier.examples;


import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.blueprint.ComponentProperty;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.ihtsdo.otf.tcc.model.index.service.SearchResult;

import java.io.IOException;
import java.util.List;

public class SearchBySctId extends AbstractQuery {

    @Override
    protected void search() throws IOException {
        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        IdentifierService idService = LookupService.getService(IdentifierService.class);
        IndexerBI snomedIdLookup = LookupService.get().getService(IndexerBI.class, "snomed id refex indexer");
        LogicService logicService = LookupService.getService(LogicService.class);

        TerminologySnapshotDI statedTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
        TerminologySnapshotDI inferredTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

        Long sctId = 131148009L;

        // Search the index for the sctId.  This will only go 5 levels deep
        int levelsToSearch = 5;
        List<SearchResult> bleedingSctidResult = snomedIdLookup.query(Long.toString(sctId), ComponentProperty.STRING_EXTENSION_1, levelsToSearch);

        if (!bleedingSctidResult.isEmpty()) {
            for (SearchResult result : bleedingSctidResult) {
                int bleedingConceptNid = result.nid;
                System.out.println("\nFound [2] nid: " + bleedingConceptNid);
                ConceptChronicleBI bleedingConcept2 = termStore.getConcept(bleedingConceptNid);
                System.out.println("Found [2]: " + bleedingConcept2);
            }
        }
    }

    public static void main(String[] args) {
        SearchBySctId searchBySctId = new SearchBySctId();
        searchBySctId.execute();
    }
}
