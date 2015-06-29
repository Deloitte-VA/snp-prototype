package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.logicgraph.FhirCodeableConceptGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Encounter;
import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Service
public class ConditionProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConditionProcessor.class);

    private final EncounterRepository encounterRepository;
    private final ClassifiedPceRepository classifiedPceRepository;

    @Inject
    public ConditionProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                              final EncounterRepository encounterRepositoryIn,
                              final ClassifiedPceRepository classifiedPceRepositoryIn) {
        super(logicGraphClassifierIn);
        classifiedPceRepository = classifiedPceRepositoryIn;
        encounterRepository = encounterRepositoryIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        LOGGER.trace("processing condition into observation(s)");

        Condition condition = (Condition) unmarshalledObject;

        // get the code
        CodeableConcept codeableConcept = condition.getCode();

        // build the logic graph from the code
        FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilder =
                new FhirCodeableConceptGraphBuilder(getLogicGraphClassifier(), codeableConcept);
        LogicGraph logicGraph = fhirCodeableConceptGraphBuilder.build();

        // classify the logic graph
        Integer classifiedLogicGraphId = getLogicGraphClassifier().classify(logicGraph);

        ClassifiedPce cPce = new ClassifiedPce();
        cPce.setNid((long) classifiedLogicGraphId);
        cPce.setDesc(logicGraph.toString());

        classifiedPceRepository.save(cPce);

        // get the reference to the encounter so that we can determine where to write to
        String encounterReference = condition.getEncounter().getReference().getValue();

        // if the encounter doesn't exist, create one
        Encounter encounter = encounterRepository.findOneByFhirId(encounterReference);
        if (encounter == null) {
            encounter = new Encounter();
            encounter.setFhirId(encounterReference);
        }
        // save the encounter
        encounterRepository.save(encounter);

	}

    @Override
    public Class processesType() {
        return Condition.class;
    }

}
