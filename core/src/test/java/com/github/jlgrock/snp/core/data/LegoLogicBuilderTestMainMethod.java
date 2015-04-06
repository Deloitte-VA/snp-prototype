package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.ochre.api.tree.TreeNodeVisitData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;

import com.github.jlgrock.snp.core.model.xml.lego.Concept;
import com.github.jlgrock.snp.core.model.xml.lego.Destination;
import com.github.jlgrock.snp.core.model.xml.lego.Expression;
import com.github.jlgrock.snp.core.model.xml.lego.Relation;
import com.github.jlgrock.snp.core.model.xml.lego.Type;

public class LegoLogicBuilderTestMainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogicGraph g = null;
    	
        /*Try to invoke new constructor for LEGO XML PCEs*/
       
		//Create the LogicGraph using the constructor meant for LEGO XMLs
    	//g = new LegoLogicGraphBuilder(439272007, "704647008", "46973005");  //Actual "IS ABOUT" concept id = 704647008 rather than 53
    	
    	Expression expression = new Expression();
    	expression = populateTestData(expression);
    	LegoLogicGraphBuilder legoLogicGraphBuilder = new LegoLogicGraphBuilder(expression);
    	legoLogicGraphBuilder.create();
    	
    	g = (LogicGraph) legoLogicGraphBuilder;
    	       
        System.out.println("Graph size=" + g.getNodeCount() );
        
        g.processDepthFirst((Node node, TreeNodeVisitData graphVisitData) -> {
            for (int i = 0; i < graphVisitData.getDistance(node.getNodeIndex()); i++) {
                System.out.print("  ");
            }
            System.out.println(node);
        });

	}
	
	private static Expression populateTestData(Expression expression) {
		//PCE source concept
		//<concept sctid="439272007" uuid="c909e67a-9925-3ebc-9e77-65227a329bea" desc="Date of procedure (observable entity)"/>
		Concept sourceConcept = new Concept();
		sourceConcept.setSctid("439272007");
		sourceConcept.setUuid("c909e67a-9925-3ebc-9e77-65227a329bea");
		sourceConcept.setDesc("Date of procedure (observable entity)");
		
		//relation type concept
		//<concept sctid="53" uuid="d82c8d16-19ad-3176-9665-453cfb2e55f0" desc="IS ABOUT (attribute)"/>
		Concept relationTypeConcept = new Concept();
		relationTypeConcept.setSctid("704647008");
		relationTypeConcept.setUuid("d82c8d16-19ad-3176-9665-453cfb2e55f0");
		relationTypeConcept.setDesc("IS ABOUT (attribute)");
		
		//destination expression
		//<concept sctid="46973005" uuid="215fd598-e21d-3e27-a0a2-8e23b1b36dfc" desc="Blood pressure taking (procedure)"/>
		Concept destinationConcept = new Concept();
		destinationConcept.setSctid("46973005");
		destinationConcept.setUuid("215fd598-e21d-3e27-a0a2-8e23b1b36dfc");
		destinationConcept.setDesc("Blood pressure taking (procedure)");
		
		expression.setConcept(sourceConcept);
		
		//Prepare Relations list
		List<Relation> relationsList = new ArrayList<Relation>();
		Relation relation = new Relation();
		
		Type type = new Type();
		type.setConcept(relationTypeConcept);
		relation.setType(type);
		
		Destination destination = new Destination();
		Expression destinationExpression = new Expression();
		destinationExpression.setConcept(destinationConcept);
		
		destination.setExpression(destinationExpression);
		relation.setDestination(destination);
		
		relationsList.add(relation);
		
		expression.setRelations(relationsList);
		
		return expression;
		
	}

}
