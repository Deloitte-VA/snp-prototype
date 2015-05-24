package com.github.jlgrock.snp.core.domain.lego.logicgraph;

import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Relation;
import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class ExpressionGraphBuilder extends AbstractLogicGraphBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExpressionGraphBuilder.class);

    private Expression expression;


    @Inject
    public ExpressionGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn) {
        super(terminologyStoreDIIn);
    }

    public void expression(final Expression expressionIn) {
        expression = expressionIn;
    }

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


    


}
