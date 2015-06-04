package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.UUID;

/**
 *
 */
@Service
public class LogicGraphClassifierImpl implements LogicGraphClassifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicGraphClassifierImpl.class);

    @Inject
	public LogicGraphClassifierImpl(final LogicClassifierStore logicClassifierStore) {
		LOGGER.info("Instantiating Classifier Service...");

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

	@Override
	public Integer classify(final LogicGraph logicGraph) {
        Integer classifiedResult = null;
//        IdentifierService idService = LookupService.getService(IdentifierService.class);
//        IndexerBI descriptionLookup = LookupService.get().getService(IndexerBI.class, "Description indexer");
//        TaxonomyService taxonomy = LookupService.getService(TaxonomyService.class);
//        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        LogicService logicService = LookupService.getService(LogicService.class);
        try {
//            TerminologySnapshotDI statedTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
//            TerminologySnapshotDI inferredTermSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

            LOGGER.debug("Stated logic graph: {}", logicGraph);

            classifiedResult = logicService.getConceptSequenceForExpression(logicGraph,
                    StampCoordinates.getDevelopmentLatest(),
                    LogicCoordinates.getStandardElProfile(),
                    EditCoordinates.getDefaultUserSolorOverlay());
            LOGGER.debug("Stated logic graph: {}", logicGraph);
        } catch (Exception e) {

        }
        return classifiedResult;
	}
}
