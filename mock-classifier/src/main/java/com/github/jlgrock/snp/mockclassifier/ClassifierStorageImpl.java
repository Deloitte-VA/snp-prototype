package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.component.concept.ConceptChronology;
import gov.vha.isaac.ochre.api.component.concept.ConceptVersion;
import gov.vha.isaac.ochre.model.concept.ConceptVersionImpl;

import java.util.UUID;

/**
 *
 */
public class ClassifierStorageImpl implements ClassifierStorage {

    @Override
    public ConceptChronology<ConceptVersionImpl> findChronicleByNid(final int nid) {
        ConceptChronology<ConceptVersionImpl> conceptChronology = null;
        return conceptChronology;
    }

    @Override
    public boolean addObject(final int nid, final ConceptChronology<ConceptVersionImpl> obj) {
        UUID uuidForNewConcept = UUID.randomUUID();

    }

    public boolean chronicleExists() {
        //findCh
    }


}
