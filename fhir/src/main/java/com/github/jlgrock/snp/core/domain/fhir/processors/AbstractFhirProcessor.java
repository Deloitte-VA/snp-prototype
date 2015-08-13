package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.logicalexpression.FhirCodeableConceptGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import com.github.jlgrock.snp.domain.types.primitives.SimplePrimitive;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract processor that stores all shared functionality for processors related to FHIR XML documents.
 */
public abstract class AbstractFhirProcessor implements FhirElementProcessorService {

    private final LogicalExpressionClassifier logicalExpressionClassifier;

    /**
     * @param logicalExpressionClassifierIn the classifier service, used for classifying logical expressions when
     *                                      built off of a particular tag.
     */
    protected AbstractFhirProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        logicalExpressionClassifier = logicalExpressionClassifierIn;
    }

    /**
     * @return the logical expression classifier, used for classifying logical expressions when encountered.
     */
    protected LogicalExpressionClassifier getLogicalExpressionClassifier() {
        return logicalExpressionClassifier;
    }

    @Override
    public abstract void process(final String identifier, final Object unmarshalledObject);

    /**
     * Parse a local identifier.  This is usually in the form of "Patient/250", so the local identifier would be 250.
     * This is meant to only be used within a fhir bundle, however we've been receiving these from the Smartform system
     * as part of independant files, so we will parse them and store them as a secondary unique identifier.
     * @param value the local identifier string
     * @return the resulting id
     */
    protected String parseFhirId(final String value) {
        return value.substring(value.indexOf('/'));
    }

    @Override
    public abstract Class processesType();

    /**
     * Process a codeable concept when encountered within a FHIR XML document.
     * @param fhirCodeableConceptBuilder the builder to build the fhir logical expression
     * @param classifiedPceRepository the repository to store the classified assertions after completion
     * @param codeableConcept the codeable concept to process
     * @return the native identifier that is achieved after classification
     */
    protected Integer processConcept(final FhirCodeableConceptGraphBuilder fhirCodeableConceptBuilder,
                                      final ClassifiedPceRepository classifiedPceRepository,
                                      final CodeableConcept codeableConcept) {
        // build the logic graph from the code
        LogicalExpression logicalExpression = fhirCodeableConceptBuilder.build(codeableConcept);

        // classify the logic graph
        Integer classifiedId = getLogicalExpressionClassifier().classify(logicalExpression);

        // save the classified PCE
        ClassifiedPce classifiedPce = new ClassifiedPce();
        classifiedPce.setNid(classifiedId);
        classifiedPce.setDesc(logicalExpression.toString());
        classifiedPceRepository.save(classifiedPce);

        // return the nid
        return classifiedPce.getNid();
    }

    /**
     * Save a concept within an encounter.
     * @param fhirCodeableConceptGraphBuilder the builder to build the fhir logical expression
     * @param classifiedPceRepository the repository to store the classified assertions
     * @param encounterRepository the repository to store the encounters
     * @param encounterReference the reference identifier for the encounter.  This is only necessary for identifying an
     *                           encounter until fhir bundles are achieved, at which point this will be part of the
     *                           data
     * @param identifier the reference identifier for the concept.  This is only necessary for identifying an
     *                           encounter until fhir bundles are achieved, at which point this will be part of the
     *                           data
     * @param observation the observation codeable concept to build a logical expression out of
     * @param provenance the provenance codeable concept to build a logical expression out of
     * @param value the value codeable concept to build a logical expression out of
     */
    protected void saveConceptToEncounter(final FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilder,
                                          final ClassifiedPceRepository classifiedPceRepository,
                                          final EncounterRepository encounterRepository,
                                          final String encounterReference,
                                          final String identifier,
                                          final CodeableConcept observation,
                                          final CodeableConcept provenance,
                                          final CodeableConcept value) {
        Encounter encounter = encounterRepository.findOneByFhirId(encounterReference);
        if (encounter == null) {
            encounter = new Encounter();
            encounter.setFhirId(encounterReference);
        }

        Assertion assertion = new Assertion();
        assertion.setFhirId(identifier);

        if (observation != null) {
            Integer observationNid = processConcept(fhirCodeableConceptGraphBuilder, classifiedPceRepository, observation);
            SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.PCE.getId(), observationNid);
            assertion.setObservable(simplePrimitive);
        }
        if (provenance != null) {
            Integer provenanceNid = processConcept(fhirCodeableConceptGraphBuilder, classifiedPceRepository, provenance);
            SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.PCE.getId(), provenanceNid);
            assertion.setProvenance(simplePrimitive);
        }
        if (value != null) {
            Integer valueNid = processConcept(fhirCodeableConceptGraphBuilder, classifiedPceRepository, value);
            SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.PCE.getId(), valueNid);
            assertion.setValue(simplePrimitive);
        }

        List<Assertion> assertionList = encounter.getAssertions();
        if (assertionList == null) {
            assertionList = new ArrayList<>();
        }
        assertionList.add(assertion);

        // save the encounter
        encounterRepository.save(encounter);
    }

}
