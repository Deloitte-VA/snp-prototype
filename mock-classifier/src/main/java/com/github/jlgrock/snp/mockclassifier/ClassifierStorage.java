package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.component.concept.ConceptChronology;
import gov.vha.isaac.ochre.model.concept.ConceptVersionImpl;

/**
 *
 */
public interface ClassifierStorage {
    ConceptChronology<ConceptVersionImpl> getByNid(int nid);

    boolean addObject(int nid, ConceptChronology<ConceptVersionImpl> obj);
}
