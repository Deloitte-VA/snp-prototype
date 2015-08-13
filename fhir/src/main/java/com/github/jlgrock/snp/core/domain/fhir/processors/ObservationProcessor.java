package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.logicalexpression.FhirCodeableConceptGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Observation;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * The processor used for handling Observation objects unmarshalled from FHIR XML.
 */
@Service
public class ObservationProcessor extends AbstractFhirProcessor {
    private final FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilder;
    private final ClassifiedPceRepository classifiedPceRepository;
    private final EncounterRepository encounterRepository;

    /**
     * Constructor.
     * @param logicalExpressionClassifierIn the classification utility for when a logical encounter is created
     * @param fhirCodeableConceptGraphBuilderIn the class that will be used for building a logical expression based off
     *                                          of a codeable concept
     * @param classifiedPceRepositoryIn the repository to store the newly created pce/assertion
     * @param encounterRepositoryIn the repository to store a newly created Encounter, if necessary
     */
    @Inject
    public ObservationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                                final FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilderIn,
                                final ClassifiedPceRepository classifiedPceRepositoryIn,
                                final EncounterRepository encounterRepositoryIn) {
        super(logicalExpressionClassifierIn);
        fhirCodeableConceptGraphBuilder = fhirCodeableConceptGraphBuilderIn;
        classifiedPceRepository = classifiedPceRepositoryIn;
        encounterRepository = encounterRepositoryIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Observation observation = (Observation) unmarshalledObject;
        String encounterReference = observation.getSubject().getReference().getValue();

		CodeableConcept observableConcept = observation.getName();
        CodeableConcept provenanceConcept = observation.getBodySite();
        CodeableConcept valueConcept = observation.getValueCodeableConcept();

        saveConceptToEncounter(
                fhirCodeableConceptGraphBuilder,
                classifiedPceRepository,
                encounterRepository,
                encounterReference,
                identifier,
                observableConcept,
                provenanceConcept,
                valueConcept
        );
	}

    @Override
    public Class processesType() {
        return Observation.class;
    }
}
