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

import com.github.jlgrock.snp.core.domain.lego.Concept;
import com.github.jlgrock.snp.core.domain.lego.Destination;
import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Relation;
import com.github.jlgrock.snp.core.domain.lego.Type;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LegoLogicGraphBuilder.class);
    private final Expression expression;

    @Override
    public void create() {
//        String sourceConceptSctid = expression.getConcept().getSctid();
//        int ?? = Integer.parseInt(sourceConceptSctid);

    	String sourceSctId = Optional.ofNullable(expression)
                .map(Expression::getConcept)
                .map(Concept::getSctid)
                .orElse(null)
                .toString();
        if (sourceSctId == null) {
            return;
        }
        
        String isAboutSctId = Optional.ofNullable(expression)
                .map(Expression::getRelation)
                .filter((List<Relation> list) -> list.size() > 0)
                .map((List<Relation> list) -> list.get(0))
                .map(Relation::getType)
                .map(Type::getConcept)
                .map(Concept::getSctid)
                .orElse(null)
                .toString();
        if (isAboutSctId == null) {
            return;
        }

        String destinationSctId = Optional.ofNullable(expression)
                .map(Expression::getRelation)
                .filter((List<Relation> list) -> list.size() > 0)
                .map((List<Relation> list) -> list.get(0))
                .map(Relation::getDestination)
                .map(Destination::getExpression)
                .map(Expression::getConcept)
                .map(Concept::getSctid)
                .orElse(null)
                .toString();
        if (destinationSctId == null) {
            return;
        }
        

        //int typeConceptNid = Integer.parseInt(isAboutSctId);
        //int destinationNid = Integer.parseInt(destinationSctId);
        
        int sourceConceptNid = 0;
        int typeConceptNid = 0;
        int destinationNid = 0;
        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        try {
            TerminologySnapshotDI termSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());
            
            //UUID bleedingSnomedUuid = UuidT3Generator.fromSNOMED(131148009L);
            //TODO: Verify if there is a way to use lookup
            UUID sourceConceptUuid = UuidT3Generator.fromSNOMED(Integer.parseInt(sourceSctId));
            UUID typeConceptUuid = UuidT3Generator.fromSNOMED(Integer.parseInt(isAboutSctId));
            UUID destinationUuid = UuidT3Generator.fromSNOMED(Integer.parseInt(destinationSctId));
            
            //Get NID from UUID
            sourceConceptNid = termSnapshot.getNidForUuids(sourceConceptUuid);  
            typeConceptNid = termSnapshot.getNidForUuids(typeConceptUuid);  
            destinationNid = termSnapshot.getNidForUuids(destinationUuid); 
            
            //Another way to get Nid
            /*
            ConceptVersionBI sourceConcept = termSnapshot.getConceptVersion(sourceConceptUuid);
            ConceptVersionBI typeConcept = termSnapshot.getConceptVersion(typeConceptUuid);
            ConceptVersionBI destinationConcept = termSnapshot.getConceptVersion(destinationUuid);
            
            sourceConceptNid = sourceConcept.getNid();
            typeConceptNid = typeConcept.getNid();
            destinationNid =  destinationConcept.getNid();
            */
        } catch (IOException ex) {
            //Logger.getLogger(LegoLogicGraphBuilder.class.getName()).log(Level.SEVERE, null, ex);
        	ex.printStackTrace();
        }
        

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
     * @param expression2 the complex expression to parse
     */
    public LegoLogicGraphBuilder(final com.github.jlgrock.snp.core.domain.lego.Expression expression) {
    	this.expression = expression;
    }
}
