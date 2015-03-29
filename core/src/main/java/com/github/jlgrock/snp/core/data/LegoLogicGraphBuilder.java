package com.github.jlgrock.snp.core.data;

import java.io.IOException;

import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;

import com.github.jlgrock.snp.core.model.parser.Expression;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;

/**
 * A Logic Graph Builder specific to Lego documents
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {

    private Expression expression;
    private LogicGraph logicGraph;

    /**
     * Set the expression to build the logic graph
     * @param expressionIn the expression to create a logic graph from
     */
    public void setExpression(final Expression expressionIn) {
        expression = expressionIn;
    }

    @Override
    public void create() {
        //TODO LogicGraph creation code goes here
    	//Look for LegoLogicGraphBuilder constructor method below
    }

    public LogicGraph getLogicGraph() {
        return logicGraph;
    }
    
    /**
     * Constructor for LogicGraph using input parameters from LEGO XML expressions
     * @param sourceConceptSctid
     * @param isAboutSctid
     * @param destinationSctid
     * @throws IOException
     * @throws ContradictionException
     */
    public LegoLogicGraphBuilder(int sourceConceptSctid,
            String isAboutSctid, //isAboutUUID,
            String destinationSctid //destinationUUID
            ) throws IOException, ContradictionException {
    	
    	int sourceConceptNid = sourceConceptSctid;
    	 //Convert from String to int
    	int typeConceptNid = Integer.parseInt(isAboutSctid);  //Do we need any converter method call to transform sctid into Nid?
    	int destinationNid = Integer.parseInt(destinationSctid); //Do we need any converter method call to transform sctid into Nid or seq id?

    	Root(SufficientSet(And(SomeRole(typeConceptNid, Concept(destinationNid))));

    }
}
