package com.github.jlgrock.snp.mockclassifier;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;

import java.util.UUID;

/**
 *
 */
public class LogicGraphClassifierQueryImpl implements LogicGraphClassifierQuery {
    @Override
    public int[] query(final int nid) {
        return new int[0];
    }

    @Override
    public int[] query(final UUID uuid) {
        return new int[0];
    }

    @Override
    public int[] query(final String sctid) {
        return new int[0];
    }

    @Override
    public int[] query(final LogicalExpression logicalExpression) {
        return new int[0];
    }
}
