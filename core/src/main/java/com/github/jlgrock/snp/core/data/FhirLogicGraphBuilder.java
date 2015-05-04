package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.core.model.xml.fihr.Condition;

/**
 * A Logic Graph Builder specific to FHIR documents.
 */
public class FhirLogicGraphBuilder extends AbstractLogicGraphBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(FhirLogicGraphBuilderTest.class);
	private final Condition condition;
	
	@Override
	public void create() {
		//Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();
        
		String sourceSctId = condition.getLocation().getCode().getCoding().getCode().getValue();
		//Get NID from UUID
    	int sourceConceptNid = getNidFromSNOMED(sourceSctId);
    	String isAboutSctId = "53";// always "IS ABOUT"
		String destinationSctId = condition.getCode().getCoding().getCode().getValue();
		//Get NID from UUID
		int typeConceptNid = getNidFromSNOMED(isAboutSctId);
		int destinationNid = getNidFromSNOMED(destinationSctId);
		
		//Create AndNode
        AndNode andNode = And();
        andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));
        root.addChildren(SufficientSet(andNode));
	}

	/**
     * Constructor for LogicGraph using input parameters from FHIR XML condition
     * @param expressionIn the complex expression to parse
     */
    public FhirLogicGraphBuilder(final Condition conditionIn) {
    	condition = conditionIn;
    }
}
