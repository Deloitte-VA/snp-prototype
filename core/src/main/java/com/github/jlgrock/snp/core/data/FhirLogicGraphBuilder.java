package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.core.model.xml.fhir.Condition;

/**
 * A Logic Graph Builder specific to FHIR documents.
 */
public class FhirLogicGraphBuilder extends AbstractLogicGraphBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(FhirLogicGraphBuilder.class);
	private final Condition condition;
	private static final String IS_ABOUT_SCTID = "53";
	
	@Override
	public void create() {
		//Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();
        
		String sourceSctId = condition.getLocation().getCode().getCoding().getCode().getValue();
		//Get NID from UUID
    	int sourceConceptNid = getNidFromSNOMED(sourceSctId);
		String destinationSctId = condition.getCode().getCoding().getCode().getValue();
		//Get NID from UUID
		int typeConceptNid = getNidFromSNOMED(IS_ABOUT_SCTID);
		int destinationNid = getNidFromSNOMED(destinationSctId);
		
		//Create AndNode
        AndNode andNode = And();
        andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));
        root.addChildren(SufficientSet(andNode));
	}

	/**
     * Constructor for LogicGraph using input parameters from FHIR XML condition
     * @param conditionIn the complex expression to parse
     */
    public FhirLogicGraphBuilder(final Condition conditionIn) {
    	condition = conditionIn;
    }

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		FhirLogicGraphBuilder that = (FhirLogicGraphBuilder) o;

		return !(condition != null ? !condition.equals(that.condition) : that.condition != null);

	}

	@Override
	public int hashCode() {
		return condition != null ? condition.hashCode() : 0;
	}
}
