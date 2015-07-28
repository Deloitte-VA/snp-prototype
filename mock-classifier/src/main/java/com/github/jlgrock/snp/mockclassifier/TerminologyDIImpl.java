package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.coordinate.StampPath;
import gov.vha.isaac.ochre.collections.ConceptSequenceSet;
import javafx.concurrent.Task;
import org.ihtsdo.otf.tcc.api.changeset.ChangeSetGenerationPolicy;
import org.ihtsdo.otf.tcc.api.changeset.ChangeSetGeneratorBI;
import org.ihtsdo.otf.tcc.api.conattr.ConceptAttributeVersionBI;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.ihtsdo.otf.tcc.api.concept.ConceptVersionBI;
import org.ihtsdo.otf.tcc.api.concept.ProcessUnfetchedConceptDataBI;
import org.ihtsdo.otf.tcc.api.coordinate.Position;
import org.ihtsdo.otf.tcc.api.coordinate.Status;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.ihtsdo.otf.tcc.api.db.DbDependency;
import org.ihtsdo.otf.tcc.api.description.DescriptionVersionBI;
import org.ihtsdo.otf.tcc.api.nid.NativeIdSetBI;
import org.ihtsdo.otf.tcc.api.refex.RefexChronicleBI;
import org.ihtsdo.otf.tcc.api.refexDynamic.RefexDynamicChronicleBI;
import org.ihtsdo.otf.tcc.api.relationship.RelationshipVersionBI;
import org.ihtsdo.otf.tcc.api.store.TerminologyDI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

/**
 *
 */
public class TerminologyDIImpl implements TerminologyDI {

    public TerminologyDIImpl() {

    }
    @Override
    public void addChangeSetGenerator(final String s, final ChangeSetGeneratorBI changeSetGeneratorBI) {

    }

    @Override
    public void addUncommitted(final ConceptChronicleBI conceptChronicleBI) throws IOException {

    }

    @Override
    public void addUncommitted(final ConceptVersionBI conceptVersionBI) throws IOException {

    }

    @Override
    public void addUncommittedNoChecks(final ConceptChronicleBI conceptChronicleBI) throws IOException {

    }

    @Override
    public void addUncommittedNoChecks(final ConceptVersionBI conceptVersionBI) throws IOException {

    }

    @Override
    public void cancel() throws IOException {

    }

    @Override
    public void cancel(final ConceptChronicleBI conceptChronicleBI) throws IOException {

    }

    @Override
    public void cancel(final ConceptVersionBI conceptVersionBI) throws IOException {

    }

    @Override
    public void commit() throws IOException {

    }

    @Override
    public void commit(final ConceptChronicleBI conceptChronicleBI) throws IOException {

    }

    @Override
    public void commit(final ConceptVersionBI conceptVersionBI) throws IOException {

    }

    @Override
    public ChangeSetGeneratorBI createDtoChangeSetGenerator(final File file1, final File file2, final ChangeSetGenerationPolicy changeSetGenerationPolicy) {
        return null;
    }

    @Override
    public boolean forget(final ConceptAttributeVersionBI conceptAttributeVersionBI) throws IOException {
        return false;
    }

    @Override
    public void forget(final ConceptChronicleBI conceptChronicleBI) throws IOException {

    }

    @Override
    public void forget(final DescriptionVersionBI descriptionVersionBI) throws IOException {

    }

    @Override
    public void forget(final RefexChronicleBI refexChronicleBI) throws IOException {

    }

    @Override
    public void forget(final RefexDynamicChronicleBI refexDynamicChronicleBI) throws IOException {

    }

    @Override
    public void forget(final RelationshipVersionBI relationshipVersionBI) throws IOException {

    }

    @Override
    public Task<?> index(Class<?>... classes) {
        return null;
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public void iterateConceptDataInParallel(final ProcessUnfetchedConceptDataBI processUnfetchedConceptDataBI) throws Exception {
        throw new UnsupportedOperationException("Deprecated");
    }

    /**
     * @deprecated
     */
    @Deprecated
    @Override
    public void iterateConceptDataInSequence(final ProcessUnfetchedConceptDataBI processUnfetchedConceptDataBI) throws Exception {
        throw new UnsupportedOperationException("Deprecated");
    }

    @Override
    public Stream<? extends ConceptChronicleBI> getConceptStream() throws IOException {
        return null;
    }

    @Override
    public Stream<? extends ConceptChronicleBI> getConceptStream(final ConceptSequenceSet conceptSequenceSet) throws IOException {
        return null;
    }

    @Override
    public Stream<? extends ConceptChronicleBI> getParallelConceptStream() throws IOException {
        return null;
    }

    @Override
    public Stream<? extends ConceptChronicleBI> getParallelConceptStream(final ConceptSequenceSet conceptSequenceSet) throws IOException {
        return null;
    }

    @Override
    public int loadEconFiles(final File... files) throws Exception {
        return 0;
    }

    @Override
    public int loadEconFiles(final Path... paths) throws Exception {
        return 0;
    }

    @Override
    public int loadEconFiles(final String... strings) throws Exception {
        return 0;
    }

    @Override
    public Position newPosition(final StampPath stampPath, long l) throws IOException {
        return null;
    }

    @Override
    public void removeChangeSetGenerator(final String s) {

    }

    @Override
    public boolean satisfiesDependencies(final Collection<DbDependency> collection) {
        return false;
    }

    @Override
    public NativeIdSetBI getAllConceptNids() throws IOException {
        return null;
    }

    @Override
    public NativeIdSetBI getAllConceptNidsFromCache() throws IOException {
        return null;
    }

    @Override
    public NativeIdSetBI getAllComponentNids() throws IOException {
        return null;
    }

    @Override
    public NativeIdSetBI getConceptNidsForComponentNids(final NativeIdSetBI nativeIdSetBI) throws IOException {
        return null;
    }

    @Override
    public NativeIdSetBI getComponentNidsForConceptNids(final NativeIdSetBI nativeIdSetBI) throws IOException {
        return null;
    }

    @Override
    public NativeIdSetBI getOrphanNids(final NativeIdSetBI nativeIdSetBI) throws IOException {
        return null;
    }

    @Override
    public int getAuthorNidForStamp(final int i) {
        return 0;
    }

    @Override
    public NativeIdSetBI getEmptyNidSet() throws IOException {
        return null;
    }

    @Override
    public ViewCoordinate getMetadataVC() throws IOException {
        return null;
    }

    @Override
    public int getModuleNidForStamp(final int i) {
        return 0;
    }

    @Override
    public StampPath getPath(final int i) throws IOException {
        return null;
    }

    @Override
    public int getPathNidForStamp(final int i) {
        return 0;
    }

    @Override
    public Set<StampPath> getPathSetFromPositionSet(final Set<Position> set) throws IOException {
        return null;
    }

    @Override
    public Set<StampPath> getPathSetFromStampSet(final Set<Integer> set) throws IOException {
        return null;
    }

    @Override
    public Set<Position> getPositionSet(final Set<Integer> set) throws IOException {
        return null;
    }

    @Override
    public Status getStatusForStamp(final int i) {
        return null;
    }

    @Override
    public long getTimeForStamp(final int i) {
        return 0;
    }

    @Override
    public int getNidForUuids(final Collection<UUID> collection) throws IOException {
        return 0;
    }

    @Override
    public Collection<UUID> getUuidCollection(final Collection<Integer> collection) throws IOException {
        return null;
    }

    @Override
    public Collection<Integer> getNidCollection(final Collection<UUID> collection) throws IOException {
        return null;
    }

    @Override
    public int getNidForUuids(final UUID... uuids) {
        return 0;
    }

    @Override
    public int getConceptNidForNid(final int i) {
        return 0;
    }

    /**
     * @deprecated use query service for alternative ids.
     */
    @Override
    public int getNidFromAlternateId(final UUID uuid, final String s) throws IOException {
        //TODO this isn't marked as deprecated in the interface - follow up in interface
        throw new UnsupportedOperationException("Deprecated");
    }

    @Override
    public CharSequence informAboutUuid(final UUID uuid) {
        return null;
    }

    @Override
    public CharSequence informAboutNid(final int i) {
        return null;
    }

    @Override
    public CharSequence informAboutId(final Object o) {
        return null;
    }
}
