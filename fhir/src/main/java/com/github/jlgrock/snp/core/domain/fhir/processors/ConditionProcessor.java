package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.logicgraph.FhirCodeableConceptGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Service
public class ConditionProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionProcessor.class);

    private final EncounterRepository encounterRepository;
    private final ClassifiedPceRepository classifiedPceRepository;
    private final FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilder;

    @Inject
    public ConditionProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                              final EncounterRepository encounterRepositoryIn,
                              final ClassifiedPceRepository classifiedPceRepositoryIn,
                              final FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilderIn) {
        super(logicGraphClassifierIn);
        classifiedPceRepository = classifiedPceRepositoryIn;
        encounterRepository = encounterRepositoryIn;
        fhirCodeableConceptGraphBuilder = fhirCodeableConceptGraphBuilderIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Condition condition = (Condition) unmarshalledObject;

        LOGGER.trace("processing condition '{}' into assertion(s)", condition);

        // get the reference to the encounter so that we can determine where to write to
        // if the encounter doesn't exist, create one
        String encounterReference = condition.getEncounter().getReference().getValue();

        // get the code
        CodeableConcept codeableConcept = condition.getCode();

        saveConceptToEncounter(
                fhirCodeableConceptGraphBuilder,
                classifiedPceRepository,
                encounterRepository,
                encounterReference,
                identifier,
                codeableConcept,
                null,
                null
        );
	}




    @Override
    public Class processesType() {
        return Condition.class;
    }

}
