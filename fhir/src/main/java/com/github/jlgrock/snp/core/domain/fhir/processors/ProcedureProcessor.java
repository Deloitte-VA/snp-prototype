package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.logicalexpression.FhirCodeableConceptGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import com.github.jlgrock.snp.domain.types.primitives.SimplePrimitive;
import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcedureProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureProcessor.class);

    private final EncounterRepository encounterRepository;
    private final ClassifiedPceRepository classifiedPceRepository;

    @Inject
    public ProcedureProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                              final EncounterRepository encounterRepositoryIn,
                              final ClassifiedPceRepository classifiedPceRepositoryIn) {
        super(logicalExpressionClassifierIn);
        classifiedPceRepository = classifiedPceRepositoryIn;
        encounterRepository = encounterRepositoryIn;
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Procedure procedure = (Procedure) unmarshalledObject;

        LOGGER.trace("processing procedure '{}' into assertion(s)", procedure);

        // get the reference to the encounter so that we can determine where to write to
        // if the encounter doesn't exist, create one
        String encounterReference = procedure.getEncounter().getReference().getValue();
        Encounter encounter = encounterRepository.findOneByFhirId(encounterReference);
        if (encounter == null) {
            encounter = new Encounter();
            encounter.setFhirId(encounterReference);
        }

        // get the code
        CodeableConcept codeableConcept = procedure.getType();

        // build the logic graph from the code
        FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilder =
                new FhirCodeableConceptGraphBuilder(getLogicalExpressionClassifier(), codeableConcept);
        LogicGraph logicGraph = fhirCodeableConceptGraphBuilder.build();

        // classify the logic graph
        Integer classifiedLogicGraphId = getLogicalExpressionClassifier().classify(logicGraph);
        ClassifiedPce cPce = new ClassifiedPce();
        cPce.setNid(classifiedLogicGraphId);
        cPce.setDesc(logicGraph.toString());

        classifiedPceRepository.save(cPce);

        Assertion assertion = new Assertion();
        assertion.setFhirId(identifier);
        SimplePrimitive simplePrimitive = SimplePrimitive.createPrimitive(PrimitiveType.PCE.getId(), cPce.getNid());
        assertion.setObservable(simplePrimitive);

        List<Assertion> assertionList = encounter.getAssertions();
        if (assertionList == null) {
            assertionList = new ArrayList<>();
        }
        assertionList.add(assertion);

        // save the encounter
        encounterRepository.save(encounter);
	}

    @Override
    public Class processesType() {
        return Procedure.class;
    }
}
