package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.Node;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Relation;

import java.util.ArrayList;
import java.util.List;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicGraphBuilder extends AbstractLogicGraphBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LegoLogicGraphBuilder.class);
    private final Expression expression;

    @Override
    public void create() {
    	//Add the nodes to the logic graph based on LEGO XML parameters
        //Create root node first
        RootNode root = getRoot();
                
        //For LEGO XML expressions, put SufficientSetNode at the top and AndNode next. For "IS ABOUT" type relationship,
        //add RoleNodeSomeWithNids as child of AndNode. For the parameters of RoleNodeSomeWithNids, use typeConceptNid and 
        //ConceptNodeWithNids as parameters.

        long sourceSctId = expression.getConcept().getSctid();
        //Get NID from UUID
    	int sourceConceptNid = getNidFromSNOMED(String.valueOf(sourceSctId));    	    	
    	List<Node> sufficientSetList = new ArrayList<>();
    	
    	if(expression.getRelation() != null && !expression.getRelation().isEmpty()) {
    		for(Relation relation: expression.getRelation()) {
    			sufficientSetList.add(processRelation(relation, sourceConceptNid));
        	}
        	
        	Node[] sufficientSetsArr = sufficientSetList.toArray(new Node[sufficientSetList.size()]);
        	root.addChildren(sufficientSetsArr);
    	}
    }
    
    /**
     * Parse the relationship
     * @param relation Relation
     * @param sourceConceptNid int
     * @return Node
     */
    public Node processRelation(final Relation relation, final int sourceConceptNid) {
    	if(relation.getDestination() != null && relation.getDestination().getExpression() != null
    			&& relation.getDestination().getExpression().getRelation() != null
    			&& !relation.getDestination().getExpression().getRelation().isEmpty()) {
    		for(Relation r : relation.getDestination().getExpression().getRelation()) {
    			return processRelation(r, sourceConceptNid);
    		}    		
    	}
    	
    	long isAboutSctId = relation.getType().getConcept().getSctid();
		long destinationSctId = relation.getDestination().getExpression().getConcept().getSctid();
		//Get NID from UUID
		int typeConceptNid = getNidFromSNOMED(String.valueOf(isAboutSctId));
		int destinationNid = getNidFromSNOMED(String.valueOf(destinationSctId));            
        
		//Create AndNode
        AndNode andNode = And();
        andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));
        return SufficientSet(andNode);
    }
    
    /**
     * Constructor for LogicGraph using input parameters from LEGO XML expressions
     * @param expressionIn the complex expression to parse
     */
    public LegoLogicGraphBuilder(final com.github.jlgrock.snp.core.domain.lego.Expression expressionIn) {
    	expression = expressionIn;
    }

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		LegoLogicGraphBuilder that = (LegoLogicGraphBuilder) o;

		return !(expression != null ? !expression.equals(that.expression) : that.expression != null);

	}

	@Override
	public int hashCode() {
		return expression != null ? expression.hashCode() : 0;
	}
}
