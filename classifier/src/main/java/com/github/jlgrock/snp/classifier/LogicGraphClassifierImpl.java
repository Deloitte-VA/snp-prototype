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
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
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
 * Class that provides classification services to ochre and lucene.
 */
@Service
public class LogicGraphClassifierImpl implements LogicGraphClassifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicGraphClassifierImpl.class);

	private final LogicClassifierStore logicClassifierStore;

    /**
     * Creates a new classifier, using ochre and lucene
     * @param logicClassifierStoreIn the store that is specific to ochre and lucene
     */
    @Inject
	public LogicGraphClassifierImpl(final LogicClassifierStore logicClassifierStoreIn) {
		LOGGER.info("Instantiating Classifier Service...");
		logicClassifierStore = logicClassifierStoreIn;
	}

    @Override
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
    public UUID getUUIDFromSNOMED(final String sctid) {
        return UuidT3Generator.fromSNOMED(131148009L);
    }

    @Override
	public ConceptChronicleBI findChronicle(final String sctid) {
		ConceptChronicleBI returnVal = null;
		try {
			TerminologyStoreDI terminologyStoreDI = logicClassifierStore.getTerminologyStore();
			UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));
			returnVal = terminologyStoreDI.getConcept(uuid);
		} catch (IOException ex) {
			LOGGER.error("Unable to get ViewCoordinates Inferred Latest", ex);
		}
		return returnVal;
	}

	@Override
	public Integer classify(final LogicGraph logicGraph) {
		LOGGER.debug("Stated logic graph: {}", logicGraph);

        LogicService logicService = LookupService.getService(LogicService.class);
		Integer classifiedResult = logicService.getConceptSequenceForExpression(logicGraph,
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());

        return classifiedResult;
	}

}
