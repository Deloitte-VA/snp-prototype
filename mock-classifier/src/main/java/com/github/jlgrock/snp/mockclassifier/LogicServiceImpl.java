package com.github.jlgrock.snp.mockclassifier;

import gov.vha.isaac.ochre.api.classifier.ClassifierService;
import gov.vha.isaac.ochre.api.component.concept.ConceptChronology;
import gov.vha.isaac.ochre.api.component.sememe.SememeChronology;
import gov.vha.isaac.ochre.api.coordinate.EditCoordinate;
import gov.vha.isaac.ochre.api.coordinate.LogicCoordinate;
import gov.vha.isaac.ochre.api.coordinate.StampCoordinate;
import gov.vha.isaac.ochre.api.logic.LogicService;
import gov.vha.isaac.ochre.api.relationship.RelationshipVersionAdaptor;

import java.util.stream.Stream;

/**
 *
 */
public class LogicServiceImpl implements LogicService {
    @Override
    public ClassifierService getClassifierService(final StampCoordinate stampCoordinate,
                                                  final LogicCoordinate logicCoordinate,
                                                  final EditCoordinate editCoordinate) {
        return null;
    }

    @Override
    public Stream<? extends SememeChronology<? extends RelationshipVersionAdaptor>> getRelationshipAdaptorsOriginatingWithConcept(final ConceptChronology conceptChronology) {
        return null;
    }

    @Override
    public Stream<? extends SememeChronology<? extends RelationshipVersionAdaptor>> getRelationshipAdaptorsOriginatingWithConcept(final ConceptChronology conceptChronology, LogicCoordinate logicCoordinate) {
        return null;
    }

    @Override
    public Stream<? extends SememeChronology<? extends RelationshipVersionAdaptor>> getRelationshipAdaptorsWithConceptAsDestination(final ConceptChronology conceptChronology) {
        return null;
    }

    @Override
    public Stream<? extends SememeChronology<? extends RelationshipVersionAdaptor>> getRelationshipAdaptorsWithConceptAsDestination(final ConceptChronology conceptChronology, LogicCoordinate logicCoordinate) {
        return null;
    }
}
