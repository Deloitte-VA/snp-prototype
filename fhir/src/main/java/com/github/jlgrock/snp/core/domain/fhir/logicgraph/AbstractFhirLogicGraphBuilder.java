package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.UUID;

/**
 * A Logic Graph Builder specific to FHIR documents.
 */
public abstract class AbstractFhirLogicGraphBuilder extends LogicGraphBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFhirLogicGraphBuilder.class);

    private final TerminologyStoreDI terminologyStoreDI;

    private static final String IS_ABOUT_SCTID = "53";

    public AbstractFhirLogicGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    /**
     * Get the native identifier
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    protected ConceptChronicleBI findChronicle(final String sctid) {
        ConceptChronicleBI returnVal = null;
        TerminologySnapshotDI terminologySnapshotDI = null;
        try {
            TerminologySnapshotDI statedTermSnapshot = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
            TerminologySnapshotDI inferredTermSnapshot = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

            UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));
            terminologySnapshotDI = terminologyStoreDI.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

            returnVal = terminologyStoreDI.getConcept(uuid);
        } catch (IOException ex) {
            LOGGER.error("Unable to get ViewCoordinates Inferred Latest", ex);
            //TODO determine what to do.  May need to refactor Campbells code if we are going to keep using this pattern
        }
        return returnVal;
    }

    /**
     * Get the native identifier
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    public int getNidFromSNOMED(final String sctid) {
        int nid = 0;
        try {
            TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
            TerminologySnapshotDI termSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());
            UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));

            //Get NID from UUID
            nid = termSnapshot.getNidForUuids(uuid);
        } catch (IOException ex) {
            LOGGER.error("Fatal error occured", ex);
        }
        return nid;
    }

}
