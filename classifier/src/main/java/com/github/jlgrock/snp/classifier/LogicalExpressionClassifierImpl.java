package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.ClassifierStorage;
import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.ochre.api.chronicle.LatestVersion;
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
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Class that provides classification services to ochre and lucene.
 */
@Service
class LogicalExpressionClassifierImpl implements LogicalExpressionClassifier {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicalExpressionClassifierImpl.class);

    private final ClassifierStorage classifierStorage;

    /**
     * Creates a new classifier, using ochre and lucene
     *
     * @param classifierStorageIn the store that is specific to ochre and lucene
     */
    @Inject
    public LogicalExpressionClassifierImpl(final ClassifierStorage classifierStorageIn) {
        classifierStorage = classifierStorageIn;
    }

    @Override
    public int getNidFromSNOMED(final String sctid) {
        TerminologyStoreDI termStore = classifierStorage.getTerminologyStore();
        TerminologySnapshotDI termSnapshot = termStore.getSnapshot(classifierStorage.getViewCoordinate());
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
            TerminologyStoreDI terminologyStoreDI = classifierStorage.getTerminologyStore();
            UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));
            returnVal = terminologyStoreDI.getConcept(uuid);
        } catch (IOException ex) {
            LOGGER.error("Unable to get ViewCoordinates Inferred Latest", ex);
        }
        return returnVal;
    }

    @Override
    public ConceptChronicleBI findChronicle(final int nid) {
        ConceptChronicleBI returnVal = null;
        try {
            TerminologyStoreDI terminologyStoreDI = classifierStorage
                    .getTerminologyStore();
            returnVal = terminologyStoreDI.getConcept(nid);
        } catch (IOException ex) {
            LOGGER.error("Unable to get ViewCoordinates Inferred Latest", ex);
        }
        return returnVal;
    }

    @Override
    public Integer classify(final LogicalExpression logicGraph) {
        LOGGER.debug("Stated logic graph: {}", logicGraph);

        Task<Integer> classifierResult = classifierStorage.
                getClassifierService().
                getConceptSequenceForExpression(
                    logicGraph,
                    EditCoordinates.getDefaultUserSolorOverlay()
                );

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

    @Override
    public LogicalExpression getInferredTermLogicalExpression(final int nid) throws IOException {
        LogicalExpression returnVal = null;
        Optional<LatestVersion<? extends LogicalExpression>> logicalExpressionOptional = classifierStorage.getLogicService().
                getLogicalExpression(nid, classifierStorage.getInferredAssemblageSequence(),
                classifierStorage.getStampCoordinate());

        if (logicalExpressionOptional.isPresent()) {
            returnVal = logicalExpressionOptional.get().value();
        }
        return returnVal;
    }

}
