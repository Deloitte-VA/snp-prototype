package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.ConceptProxy;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.chronicle.ObjectChronologyType;
import gov.vha.isaac.ochre.collections.ConceptSequenceSet;
import gov.vha.isaac.ochre.collections.NidSet;
import gov.vha.isaac.ochre.collections.RefexSequenceSet;
import gov.vha.isaac.ochre.collections.SememeSequenceSet;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 *
 */
public class IdentifierServiceImpl implements IdentifierService {
    @Override
    public ObjectChronologyType getChronologyTypeForNid(int i) {
        return null;
    }

    @Override
    public NidSet getComponentNidsForConceptNids(ConceptSequenceSet conceptSequenceSet) {
        return null;
    }

    @Override
    public IntStream getComponentNidStream() {
        return null;
    }

    @Override
    public int getConceptNidForDescriptionNid(int i) {
        return 0;
    }

    @Override
    public int getConceptSequenceForDescriptionNid(int i) {
        return 0;
    }

    @Override
    public void setConceptSequenceForComponentNid(int i, int i1) {

    }

    @Override
    public void resetConceptSequenceForComponentNid(int i, int i1) {

    }

    @Override
    public int getConceptSequence(int i) {
        return 0;
    }

    @Override
    public int getConceptNid(int i) {
        return 0;
    }

    @Override
    public IntStream getConceptSequenceStream() {
        return null;
    }

    @Override
    public IntStream getParallelConceptSequenceStream() {
        return null;
    }

    @Override
    public int getSememeSequence(int i) {
        return 0;
    }

    @Override
    public int getSememeNid(int i) {
        return 0;
    }

    @Override
    public int getSememeSequenceForUuids(Collection<UUID> collection) {
        return 0;
    }

    @Override
    public int getSememeSequenceForUuids(UUID... uuids) {
        return 0;
    }

    @Override
    public IntStream getSememeSequenceStream() {
        return null;
    }

    @Override
    public IntStream getParallelSememeSequenceStream() {
        return null;
    }

    @Override
    public ConceptSequenceSet getConceptSequencesForConceptNids(NidSet nidSet) {
        return null;
    }

    @Override
    public ConceptSequenceSet getConceptSequencesForConceptNids(int[] ints) {
        return null;
    }

    @Override
    public SememeSequenceSet getSememeSequencesForSememeNids(int[] ints) {
        return null;
    }

    @Override
    public ConceptSequenceSet getConceptSequencesForReferencedComponents(SememeSequenceSet sememeSequenceSet) {
        return null;
    }

    @Override
    public ConceptSequenceSet getConceptSequenceSetForComponentNidSet(NidSet nidSet) {
        return null;
    }

    @Override
    public IntStream getConceptNidsForConceptSequences(IntStream intStream) {
        return null;
    }

    @Override
    public IntStream getSememeNidsForSememeSequences(IntStream intStream) {
        return null;
    }

    @Override
    public int getNidForUuids(Collection<UUID> collection) {
        return 0;
    }

    @Override
    public int getNidForUuids(UUID... uuids) {
        return 0;
    }

    @Override
    public int getNidForProxy(ConceptProxy conceptProxy) {
        return 0;
    }

    @Override
    public int getConceptSequenceForUuids(Collection<UUID> collection) {
        return 0;
    }

    @Override
    public int getConceptSequenceForUuids(UUID... uuids) {
        return 0;
    }

    @Override
    public int getConceptSequenceForProxy(ConceptProxy conceptProxy) {
        return 0;
    }

    @Override
    public void addUuidForNid(UUID uuid, int i) {

    }

    @Override
    public Optional<UUID> getUuidPrimordialForNid(int i) {
        return null;
    }

    @Override
    public Optional<UUID> getUuidPrimordialFromConceptSequence(int i) {
        return null;
    }

    @Override
    public List<UUID> getUuidsForNid(int i) {
        return null;
    }

    @Override
    public boolean hasUuid(UUID... uuids) {
        return false;
    }

    @Override
    public boolean hasUuid(Collection<UUID> collection) {
        return false;
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public int getConceptSequenceForComponentNid(int i) {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public int getRefexSequence(int i) {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public int getRefexNid(int i) {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public IntStream getRefexSequenceStream() {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public IntStream getParallelRefexSequenceStream() {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public IntStream getRefexNidsForSequences(IntStream intStream) {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public RefexSequenceSet getRefexSequencesForNids(int[] ints) {
        throw new UnsupportedOperationException("Deprecated");
    }
}
