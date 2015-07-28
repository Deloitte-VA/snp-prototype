package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.TaxonomyService;
import org.ihtsdo.otf.tcc.api.blueprint.TerminologyBuilderBI;
import org.ihtsdo.otf.tcc.api.chronicle.ComponentChronicleBI;
import org.ihtsdo.otf.tcc.api.chronicle.ComponentContainerBI;
import org.ihtsdo.otf.tcc.api.chronicle.ComponentVersionBI;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.concept.ConceptContainerBI;
import org.ihtsdo.otf.tcc.api.concept.ConceptVersionBI;
import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;
import org.ihtsdo.otf.tcc.api.coordinate.EditCoordinate;
import org.ihtsdo.otf.tcc.api.coordinate.ExternalStampBI;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.ihtsdo.otf.tcc.api.db.DbDependency;
import org.ihtsdo.otf.tcc.api.nid.IntSet;
import org.ihtsdo.otf.tcc.api.nid.NativeIdSetBI;
import org.ihtsdo.otf.tcc.api.refex.RefexChronicleBI;
import org.ihtsdo.otf.tcc.api.refexDynamic.RefexDynamicChronicleBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.cc.termstore.TerminologySnapshot;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 *
 */
public class TerminologyStoreDIImpl extends TerminologyDIImpl implements TerminologyStoreDI {
    private final TaxonomyService taxonomyService;
    private final IdentifierService identifierService;

    public TerminologyStoreDIImpl(final TaxonomyService taxonomyServiceIn,
                                  final IdentifierService identifierServiceIn) {
        taxonomyService = taxonomyServiceIn;
        identifierService = identifierServiceIn;
    }
    /**
     * Don't use this
     * @deprecated
     */
    @Deprecated
    @Override
    public boolean isConceptNid(final int nid) {
        return getConceptNidForNid(nid) == nid;
    }


    @Override
    public NativeIdSetBI isChildOfSet(final int parentNid, final ViewCoordinate viewCoordinate) {
        IntStream childrenSequences = taxonomyService.
                getTaxonomyChildSequences(identifierService.getConceptSequence(parentNid), viewCoordinate);
        NativeIdSetBI childNidSet = new IntSet();
        childrenSequences.forEach((sequence) -> childNidSet.add(identifierService.getConceptNid(sequence)));
        return childNidSet;
    }

    @Override
    public NativeIdSetBI relationshipSet(final int parentNid, final ViewCoordinate viewCoordinate) {
        throw new UnsupportedOperationException("Not supported in cradle...");
    }

    @Override
    public ComponentChronicleBI<?> getComponent(final Collection<UUID> collection) throws IOException {

    }

    @Override
    public ComponentChronicleBI<?> getComponent(final ComponentContainerBI componentContainerBI) throws IOException {

    }

    @Override
    public ComponentChronicleBI<?> getComponent(final int nid) throws IOException {
        return null;
    }

    @Override
    public ComponentChronicleBI<?> getComponent(final UUID... uuids) throws IOException {
        return null;
    }

    @Override
    public RefexChronicleBI<?> getRefex(final int i) {
        return null;
    }

    @Override
    public RefexDynamicChronicleBI<?> getDynamicRefex(final int i) {
        return null;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getRefexesForAssemblage(final int i) {
        return null;
    }

    @Override
    public Collection<? extends RefexChronicleBI<?>> getRefexesForComponent(final int i) {
        return null;
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public ComponentChronicleBI<?> getComponentFromAlternateId(final int i, final String s) throws IOException {
        throw new UnsupportedOperationException("Deprecated");
    }

    @Override
    public Optional<? extends ComponentVersionBI> getComponentVersion(final ViewCoordinate viewCoordinate, final Collection<UUID> collection) throws IOException, ContradictionException {
        return null;
    }

    @Override
    public Optional<? extends ComponentVersionBI> getComponentVersion(final ViewCoordinate viewCoordinate, final int i) throws IOException, ContradictionException {
        return null;
    }

    @Override
    public Optional<? extends ComponentVersionBI> getComponentVersion(final ViewCoordinate viewCoordinate, final UUID... uuids) throws IOException, ContradictionException {
        return null;
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public Optional<? extends ComponentVersionBI> getComponentVersionFromAlternateId(final ViewCoordinate viewCoordinate, final int i, final String s) throws IOException, ContradictionException {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public Optional<? extends ComponentVersionBI> getComponentVersionFromAlternateId(final ViewCoordinate viewCoordinate, final UUID uuid, final String s) throws IOException, ContradictionException {
        throw new UnsupportedOperationException("Deprecated");
    }

    @Override
    public ConceptChronicleBI getConcept(final Collection<UUID> collection) throws IOException {
        return null;
    }

    @Override
    public ConceptChronicleBI getConcept(final ConceptContainerBI conceptContainerBI) throws IOException {
        return null;
    }

    @Override
    public ConceptChronicleBI getConcept(final int i) throws IOException {
        return null;
    }

    @Override
    public ConceptChronicleBI getConcept(final UUID... uuids) throws IOException {
        return null;
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public ConceptChronicleBI getConceptFromAlternateId(final int i, final String s) throws IOException {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public ConceptChronicleBI getConceptFromAlternateId(final UUID uuid, final String s) throws IOException {
        throw new UnsupportedOperationException("Deprecated");
    }

    @Override
    public ConceptChronicleBI getConceptForNid(final int i) throws IOException {
        return null;
    }

    @Override
    public ConceptVersionBI getConceptVersion(final ViewCoordinate viewCoordinate, final Collection<UUID> collection) throws IOException {
        return null;
    }

    @Override
    public ConceptVersionBI getConceptVersion(final ViewCoordinate viewCoordinate, final int i) throws IOException {
        return null;
    }

    @Override
    public ConceptVersionBI getConceptVersion(final ViewCoordinate viewCoordinate, final UUID... uuids) throws IOException {
        return null;
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public ConceptVersionBI getConceptVersionFromAlternateId(final ViewCoordinate viewCoordinate, final int i, final String s) throws IOException {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Deprecated
    @Override
    public ConceptVersionBI getConceptVersionFromAlternateId(final ViewCoordinate viewCoordinate, final UUID uuid, final String s) throws IOException {
        throw new UnsupportedOperationException("Deprecated");
    }

    @Override
    public Map<Integer, ConceptVersionBI> getConceptVersions(final ViewCoordinate viewCoordinate, final NativeIdSetBI nativeIdSetBI) throws IOException {
        return null;
    }

    @Override
    public Map<Integer, ConceptChronicleBI> getConcepts(final NativeIdSetBI nativeIdSetBI) throws IOException {
        return null;
    }

    @Override
    public Collection<DbDependency> getLatestChangeSetDependencies() throws IOException {
        throw new UnsupportedOperationException("Not supported in cradle...");
    }

    @Override
    public int[] getPossibleChildren(final int i, final ViewCoordinate viewCoordinate) throws IOException {
        throw new UnsupportedOperationException("Not supported in cradle...");
    }

    @Override
    public TerminologySnapshotDI getSnapshot(final ViewCoordinate viewCoordinate) {
        return new TerminologySnapshot(this, viewCoordinate);
    }

    @Override
    public TerminologySnapshotDI cacheSnapshot(final UUID uuid, final ViewCoordinate viewCoordinate) {
        return null;
    }

    @Override
    public TerminologySnapshotDI getCachedSnapshot(final UUID uuid) throws NoSuchElementException {
        return null;
    }

    @Override
    public TerminologySnapshotDI getGlobalSnapshot() {
        return null;
    }

    @Override
    public void setGlobalSnapshot(final TerminologySnapshotDI terminologySnapshotDI) {

    }

    @Override
    public TerminologyBuilderBI getTerminologyBuilder(final EditCoordinate editCoordinate, final ViewCoordinate viewCoordinate) {
        return null;
    }

    @Override
    public Collection<? extends ConceptChronicleBI> getUncommittedConcepts() {
        throw new UnsupportedOperationException("This is an unimplemented method in all systems");
    }

    @Override
    public UUID getUuidPrimordialForNid(final int i) throws IOException {
        return null;
    }

    @Override
    public List<UUID> getUuidsForNid(final int i) throws IOException {
        return null;
    }

    @Override
    public boolean hasPath(final int i) throws IOException {
        return false;
    }

    @Override
    public boolean hasUncommittedChanges() {
        return false;
    }

    @Override
    public boolean hasConcept(final UUID uuid) {
        return false;
    }

    @Override
    public boolean hasConcept(int i) {
        return false;
    }

    @Override
    public boolean hasUuid(final UUID uuid) {
        return false;
    }

    @Override
    public boolean hasUuid(final List<UUID> list) {
        return false;
    }

    @Override
    public long getSequence() {
        return 0;
    }

    @Override
    public int getConceptCount() throws IOException {
        return 0;
    }

    @Override
    public int getStamp(final ExternalStampBI externalStampBI) throws IOException {
        return 0;
    }

    @Override
    public ViewCoordinate getViewCoordinate(final UUID uuid) throws IOException {
        return null;
    }

    @Override
    public Collection<ViewCoordinate> getViewCoordinates() throws IOException {
        return null;
    }

    @Override
    public void putViewCoordinate(final ViewCoordinate viewCoordinate) throws IOException {

    }

    @Override
    public boolean isKindOf(final int i, final int j, final ViewCoordinate viewCoordinate) throws IOException, ContradictionException {
        return false;
    }

    @Override
    public boolean isChildOf(final int i, final int j, final ViewCoordinate viewCoordinate) throws IOException, ContradictionException {
        return false;
    }

    @Override
    public NativeIdSetBI isKindOfSet(final int i, final ViewCoordinate viewCoordinate) {
        return null;
    }

    @Override
    public void shutdown() {

    }
}
