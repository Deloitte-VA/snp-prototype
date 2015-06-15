package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.collections.SequenceSet;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Class that provides query capabilities for the Logic Graph store.
 */
@Service
public class LogicGraphClassifierQueryImpl implements LogicGraphClassifierQuery {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogicGraphClassifierQueryImpl.class);

    private final LogicClassifierStore logicClassifierStore;

    /**
     * Creates the classifier query object
     *
     * @param logicClassifierStoreIn the specific store to use, in this case, ochre+lucene
     */
    @Inject
    public LogicGraphClassifierQueryImpl(final LogicClassifierStore logicClassifierStoreIn) {
        logicClassifierStore = logicClassifierStoreIn;
    }

    @Override
    public List<Integer> query(final int nid) {
        List<Integer> conceptSequences = Collections.emptyList();
        SequenceSet results = null;
        try {
            results = logicClassifierStore.getTaxonomyService()
                    .getKindOfSequenceSet(nid, ViewCoordinates.getDevelopmentInferredLatest());
        } catch (IOException e) {
            LOGGER.error("Unable to getDevelopmentInferredLatest ", e);
        }
        if (results != null) {
            conceptSequences = results.stream().boxed().collect(Collectors.toList());
        }
        return conceptSequences;
    }

    @Override
    public List<Integer> query(final UUID uuid) {
        List<Integer> conceptSequences = Collections.EMPTY_LIST;

        ConceptChronicleBI concept = null;
        try {
            concept = logicClassifierStore.getTerminologyStore().getConcept(uuid);
            int nid = concept.getNid();
            conceptSequences = query(nid);

        } catch (IOException e) {
            LOGGER.error("Unable to get a concept using the uuid " + uuid, e);
        }
        return conceptSequences;
    }

    @Override
    public List<Integer> query(final String sctId) {
        // Convert the sctId into a UUID
        UUID uuid = UuidT3Generator.fromSNOMED(sctId);
        // execute a uuid query
        return query(uuid);
    }

    @Override
    public List<Integer> query(final LogicGraph logicGraph) {
        //TODO
        throw new UnsupportedOperationException("Work on this");
    }
}
