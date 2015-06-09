package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import org.ihtsdo.otf.tcc.api.blueprint.ComponentProperty;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;
import org.ihtsdo.otf.tcc.model.index.service.SearchResult;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that provides query capabilities for the Logic Graph store.
 */
@Service
public class LogicGraphClassifierQueryImpl implements LogicGraphClassifierQuery {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogicGraphClassifierQueryImpl.class);

    private static final int MAX_DEPTH = 5;

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
    public List<Integer> query(final String id) {
        List<Integer> queryResults = new ArrayList<>();
        try {
            IndexerBI snomedIdLookup = logicClassifierStore.getIndexer();
            List<SearchResult> sctidResults = snomedIdLookup.query(id,
                    ComponentProperty.STRING_EXTENSION_1, LogicGraphClassifierQueryImpl.MAX_DEPTH);
            sctidResults.forEach(sctidResult -> queryResults.add(sctidResult.getNid()));
        } catch (IOException ioe) {
            LOGGER.error("There was an error executing the Classifier query", ioe);
        }
        return queryResults;
    }
}
