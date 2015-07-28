package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.ochre.api.classifier.ClassifierService;
import gov.vha.isaac.ochre.api.logic.LogicService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import gov.vha.isaac.ochre.util.UuidT3Generator;
import javafx.concurrent.Task;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Class that provides classification services to ochre and lucene.
 */
@Service
public class LogicalExpressionClassifierImpl implements LogicalExpressionClassifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicalExpressionClassifierImpl.class);

    private final LogicClassifierStore logicClassifierStore;

    /**
     * Creates a new classifier, using ochre and lucene
     *
     * @param logicClassifierStoreIn the store that is specific to ochre and lucene
     */
    @Inject
    public LogicalExpressionClassifierImpl(final LogicClassifierStore logicClassifierStoreIn) {
        LOGGER.info("Instantiating Classifier Service...");
        logicClassifierStore = logicClassifierStoreIn;
    }

    @Override
    public int getNidFromSNOMED(final String sctid) {
        TerminologyStoreDI termStore = logicClassifierStore.getTerminologyStore();
        TerminologySnapshotDI termSnapshot = termStore.getSnapshot(logicClassifierStore.getViewCoordinate());
        UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));

        //Get NID from UUID
        return termSnapshot.getNidForUuids(uuid);
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
    public Integer classify(final LogicalExpression logicGraph) {
        LOGGER.debug("Stated logic graph: {}", logicGraph);

        LogicService logicService = logicClassifierStore.getLogicService();
        ClassifierService classifierService =
                logicService.getClassifierService(
                        StampCoordinates.getDevelopmentLatest(),
                        LogicCoordinates.getStandardElProfile(),
                        EditCoordinates.getDefaultUserSolorOverlay());
        Task<Integer> classifierResult = classifierService.getConceptSequenceForExpression(
                logicGraph,
                EditCoordinates.getDefaultUserSolorOverlay());

        Integer returnVal = null;
        try {
            returnVal = classifierResult.get();
        } catch (InterruptedException ie) {
            LOGGER.error("There was an interruption classifying the logic graph {}", logicGraph, ie);
        } catch (ExecutionException ee) {
            LOGGER.error("There was an execution exception classifying the logic graph {}", logicGraph, ee);
        }
        return returnVal;
    }

}
