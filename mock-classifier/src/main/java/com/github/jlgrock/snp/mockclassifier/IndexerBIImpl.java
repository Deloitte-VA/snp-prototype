package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.index.SearchResult;
import org.ihtsdo.otf.tcc.api.blueprint.ComponentProperty;
import org.ihtsdo.otf.tcc.model.index.service.IndexerBI;

import java.util.List;

/**
 *
 */
public class IndexerBIImpl extends IndexServiceImpl implements IndexerBI {
    @Override
    public List<SearchResult> query(final String query, final ComponentProperty field, final int sizeLimit) {
        return null;
    }

    @Override
    public List<SearchResult> query(final String query, final ComponentProperty field, final int sizeLimit, final long targetGeneration) {
        return null;
    }
}
