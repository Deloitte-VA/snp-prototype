package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.api.TaxonomySnapshotService;
import gov.vha.isaac.ochre.api.coordinate.TaxonomyCoordinate;
import gov.vha.isaac.ochre.api.tree.Tree;
import gov.vha.isaac.ochre.collections.ConceptSequenceSet;

import java.util.stream.IntStream;

/**
 *
 */
public class TaxonomyServiceImpl implements TaxonomyService {
    @Override
    public TaxonomySnapshotService getSnapshot(final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public Tree getTaxonomyTree(final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public boolean isChildOf(final int childId,
                             final int parentId,
                             final TaxonomyCoordinate tc) {
        return false;
    }

    @Override
    public boolean isKindOf(final int childId,
                            final int parentId,
                            final TaxonomyCoordinate tc) {
        return false;
    }

    @Override
    public boolean wasEverKindOf(final int childId,
                                 final int parentId) {
        return false;
    }

    @Override
    public ConceptSequenceSet getKindOfSequenceSet(final int rootId,
                                                   final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public ConceptSequenceSet getChildOfSequenceSet(final int parentId,
                                                    final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipOriginSequences(final int destinationId,
                                                       final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipOriginSequences(final int destinationId) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipDestinationSequences(final int originId,
                                                            final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipDestinationSequences(final int originId) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipDestinationSequencesOfType(final int originId,
                                                                  final ConceptSequenceSet typeSequenceSet,
                                                                  final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipDestinationSequencesOfType(final int originId,
                                                                  final ConceptSequenceSet typeSequenceSet) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipOriginSequencesOfType(final int destinationId,
                                                             final ConceptSequenceSet typeSequenceSet,
                                                             final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getAllRelationshipOriginSequencesOfType(final int destinationId,
                                                             final ConceptSequenceSet typeSequenceSet) {
        return null;
    }

    @Override
    public IntStream getTaxonomyChildSequences(final int parentId,
                                               final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getTaxonomyChildSequences(final int parentId) {
        return null;
    }

    @Override
    public IntStream getTaxonomyParentSequences(final int childId,
                                                final TaxonomyCoordinate tc) {
        return null;
    }

    @Override
    public IntStream getTaxonomyParentSequences(final int childId) {
        return null;
    }

    @Override
    public IntStream getRoots(final TaxonomyCoordinate sc) {
        return null;
    }
}
