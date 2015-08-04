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
 *
 */
public abstract class AbstractFhirProcessor implements FhirElementProcessorService {

    private final LogicalExpressionClassifier logicalExpressionClassifier;

    protected AbstractFhirProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        logicalExpressionClassifier = logicalExpressionClassifierIn;
    }

    protected LogicalExpressionClassifier getLogicalExpressionClassifier() {
        return logicalExpressionClassifier;
    }

    @Override
    public abstract void process(final String identifier, final Object unmarshalledObject);

    protected String parseFhirId(String value) {
        return value.substring(value.indexOf('/'));
    }

    @Override
    public abstract Class processesType();

    protected  Integer processConcept(final FhirCodeableConceptGraphBuilder fhirCodeableConceptBuilder,
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
