package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.collections.SequenceSet;
import gov.vha.isaac.ochre.util.UuidT3Generator;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

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
    public int[] query(final int nid) {
    	LOGGER.trace("query(nid={})", nid);
        int[] conceptSequences = null;
        SequenceSet results = null;
        results = logicClassifierStore.getTaxonomyService()
                .getKindOfSequenceSet(nid, logicClassifierStore.getViewCoordinates());
        if (results != null) {
            conceptSequences = results.stream().toArray();
        }
        LOGGER.debug("conceptSequences={}", Arrays.toString(conceptSequences));
        return conceptSequences;
    }

    @Override
    public int[] query(final UUID uuid) {
        int[] conceptSequences = null;

        ConceptChronicleBI concept;
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
    public int[] query(final String sctId) {
        // Convert the sctId into a UUID
        UUID uuid = UuidT3Generator.fromSNOMED(sctId);
        // execute a uuid query
        return query(uuid);
    }

    @Override
    public int[] query(final LogicGraph logicGraph) {
        //TODO
        throw new UnsupportedOperationException("Work on this");
    }
}
