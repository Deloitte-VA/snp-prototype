package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.ClassifierStorage;
import com.github.jlgrock.snp.apis.classifier.ClassifierQuery;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
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
public class ClassifierQueryImpl implements ClassifierQuery {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierQueryImpl.class);

    private final ClassifierStorage classifierStorage;

    /**
     * Creates the classifier query object
     *
     * @param classifierStorageIn the specific store to use, in this case, ochre+lucene
     */
    @Inject
    public ClassifierQueryImpl(final ClassifierStorage classifierStorageIn) {
        classifierStorage = classifierStorageIn;
    }

    @Override
    public int[] query(final int nid) {
    	LOGGER.trace("query(nid={})", nid);
        int[] conceptSequences = null;
        SequenceSet results = null;
        results = classifierStorage.getTaxonomyService()
                .getKindOfSequenceSet(nid, classifierStorage.getViewCoordinate());
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
            concept = classifierStorage.getTerminologyStore().getConcept(uuid);
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
    public int[] query(final LogicalExpression logicalExpression) {
        //TODO
        throw new UnsupportedOperationException("Work on this");
    }
}
