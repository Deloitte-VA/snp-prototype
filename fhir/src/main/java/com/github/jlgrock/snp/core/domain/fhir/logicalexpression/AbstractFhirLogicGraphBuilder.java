package com.github.jlgrock.snp.core.domain.fhir.logicalexpression;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Code;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Coding;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilder;
import gov.vha.isaac.ochre.api.logic.LogicalExpressionBuilderService;
import gov.vha.isaac.ochre.api.logic.assertions.ConceptAssertion;
import gov.vha.isaac.ochre.api.logic.assertions.connectors.And;
import org.ihtsdo.otf.tcc.api.spec.ConceptSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Shared functionality for creating Logical Expressions specific to FHIR documents.
 */
public abstract class AbstractFhirLogicGraphBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractFhirLogicGraphBuilder.class);

    private LogicalExpressionBuilder logicalExpressionBuilder;

    private final LogicalExpressionClassifier logicalExpressionClassifier;

    private static final String IS_ABOUT_SCTID = "53";

    /**
     * Shared functionality for creating logical expressions.  This currently has a hard dependency on the va-logic
     * package.  This should be removed at a later point, but it was the fastest way to get a logical expression
     * built at the current point.  At the very least, it should be moved into the classifier service.
     *
     * @param logicalExpressionClassifierIn the tool for classifying logical expressions.
     */
    protected AbstractFhirLogicGraphBuilder(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        logicalExpressionClassifier = logicalExpressionClassifierIn;
        // This needs to be encapsulated as it creates a hard dependency with no injection point to replace it
        LogicalExpressionBuilderService expressionBuilderService = LookupService.getService(LogicalExpressionBuilderService.class);
        logicalExpressionBuilder = expressionBuilderService.getLogicalExpressionBuilder();
    }

    /**
     * @return get the current logical expression builder, to turn it into a logic expression/graph
     */
    protected LogicalExpressionBuilder getLogicalExpressionBuilder() {
        return logicalExpressionBuilder;
    }

    /**
     * Build a logical expression from a particular codeable concept
     * @param codeableConcept the concept to build from
     * @return the AND from a logical expression, in the off chance that it part of a larger body of expressions
     */
    protected And buildCodeableConcept(final CodeableConcept codeableConcept) {
        LOGGER.trace("Building a Codeable Concept: {}", codeableConcept);

        List<Coding> codingList = codeableConcept.getCoding();
        List<ConceptAssertion> childrenList = new ArrayList<>();
        for (Coding coding : codingList) {
            Code code = coding.getCode();

            UUID uuid;
            coding.getSystem();

            if (coding.getSystem() == null || !"http://snomed.info/sct".equalsIgnoreCase(coding.getSystem().getValue())) {
                throw new UnsupportedOperationException("Only can handle snomed ids currently");
            }

            String id = code.getValue();
            if (id == null) {
                throw new UnsupportedOperationException("Coding must have a unique identifier");
            }
            uuid = logicalExpressionClassifier.getUUIDFromSNOMED(id);
            String description = coding.getDisplay().getValue();
            ConceptSpec conceptSpec = new ConceptSpec(description, uuid);
            childrenList.add(LogicalExpressionBuilder.ConceptAssertion(conceptSpec, logicalExpressionBuilder));
        }
        And and = LogicalExpressionBuilder.And(childrenList.toArray(new ConceptAssertion[childrenList.size()]));
        return and;
    }

    /**
     * Build a logical expression from a codeable concept
     * @param codeableConcept the concept to build
     * @return the logical expression to create
     */
    public abstract LogicalExpression build(final CodeableConcept codeableConcept);
}
