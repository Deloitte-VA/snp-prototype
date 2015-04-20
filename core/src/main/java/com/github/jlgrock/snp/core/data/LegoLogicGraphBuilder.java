package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;
import gov.vha.isaac.lookup.constants.Constants;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.core.model.xml.lego.Expression;
import com.github.jlgrock.snp.core.model.xml.lego.Relation;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {
	
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

        String sourceSctId = expression.getConcept().getSctid();
        //Get NID from UUID
    	int sourceConceptNid = getNidFromSNOMED(sourceSctId);    	    	
    	List<Node> sufficientSetList = new ArrayList<>();
    	
    	if(expression.getRelations() != null && !expression.getRelations().isEmpty()) {
    		for(Relation relation: expression.getRelations()) {
    			sufficientSetList.add(processRelation(relation, sourceConceptNid));
        	}
        	
        	Node[] sufficientSetsArr = sufficientSetList.toArray(new Node[sufficientSetList.size()]);
        	root.addChildren(sufficientSetsArr);
    	}
    	
    	//Another way to get Nid
    	/*
         ConceptVersionBI sourceConcept = termSnapshot.getConceptVersion(sourceConceptUuid);
         ConceptVersionBI typeConcept = termSnapshot.getConceptVersion(typeConceptUuid);
         ConceptVersionBI destinationConcept = termSnapshot.getConceptVersion(destinationUuid);

         sourceConceptNid = sourceConcept.getNid();
         typeConceptNid = typeConcept.getNid();
         destinationNid =  destinationConcept.getNid();
    	 */
    	
    	//The following alternate approach to create logic graph gives somehow class cast Exception for root node
    	/*
          RootNode root = Root(
          					SufficientSet(
      							And(
    	  							Concept(sourceConceptNid), 
    	  							SomeRole(typeConceptNid, Concept(destinationNid))
        						)));
    	 */
    }
    
    public Node processRelation(Relation relation, int sourceConceptNid) {
    	if(relation.getDestination() != null && relation.getDestination().getExpression() != null
    			&& relation.getDestination().getExpression().getRelations() != null
    			&& !relation.getDestination().getExpression().getRelations().isEmpty()) {
    		for(Relation r : relation.getDestination().getExpression().getRelations()) {
    			return processRelation(r, sourceConceptNid);
    		}    		
    	}
    	
    	String isAboutSctId = relation.getType().getConcept().getSctid();
		String destinationSctId = relation.getDestination().getExpression().getConcept().getSctid();
		//Get NID from UUID
		int typeConceptNid = getNidFromSNOMED(isAboutSctId);
		int destinationNid = getNidFromSNOMED(destinationSctId);            
        
		//Create AndNode
        AndNode andNode = And();
        andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));
        return SufficientSet(andNode);
    }
        
    public int getNidFromSNOMED(String sctid) {
    	int nid = 0;
    	try {
    		TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
    		TerminologySnapshotDI termSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());  	    
    		UUID uuid = UuidT3Generator.fromSNOMED(Long.parseLong(sctid));

    		//Get NID from UUID
    		nid = termSnapshot.getNidForUuids(uuid);  
    	} catch (IOException ex) {
    		LOGGER.error("Fatal error occured", ex);
    	}
    	return nid;
    }
    
    public static void startExpressionService() {
    	if(LookupService.getRunLevelController().getCurrentRunLevel() != 2) {
			System.setProperty(Constants.CHRONICLE_COLLECTIONS_ROOT_LOCATION_PROPERTY, "target/data/object-chronicles");
    		System.setProperty(Constants.SEARCH_ROOT_LOCATION_PROPERTY, "target/data/search");

    		LookupService.getRunLevelController().proceedTo(2);
    		LOGGER.info("System up...");	
		} else {
			LOGGER.info("System already up and running!");
		}
    }
    
    public static void stopExpressionService() {
    	LookupService.getRunLevelController().proceedTo(-1);
	    LOGGER.info("System down...");
    }
    
    /**
     * Constructor for LogicGraph using input parameters from LEGO XML expressions
     * @param expressionIn the complex expression to parse
     */
    public LegoLogicGraphBuilder(final Expression expressionIn) {
    	expression = expressionIn;
    }
}
