package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.And;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.Connector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FhirEncounterGraphBuilder extends AbstractFhirLogicGraphBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FhirProcedureGraphBuilder.class);

    final Encounter encounter;

    @Override
    public LogicGraph build() {
        Connector connector = processEncounter(encounter);
        LogicalExpressionBuilder.SufficientSet(connector);
        return (LogicGraph) getLogicalExpressionBuilder().build();
    }

    public FhirEncounterGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final Encounter encounterIn) {
        super(logicGraphClassifierIn);
        encounter = encounterIn;
    }

    protected And processEncounter(final Encounter encounter) {
        LOGGER.trace("Creating Fhir Encounter Logic Graph");
        List<CodeableConcept> typeList = encounter.getType();
        List<And> childrenNodes = new ArrayList<>();

        //TODO so many other possible fields to look into.  just using one currently

        // add source
        for (CodeableConcept codeableConcept : typeList) {
            childrenNodes.add(buildCodeableConcept(codeableConcept));
        }

        return LogicalExpressionBuilder.And(new And[childrenNodes.size()]);
    }

}
