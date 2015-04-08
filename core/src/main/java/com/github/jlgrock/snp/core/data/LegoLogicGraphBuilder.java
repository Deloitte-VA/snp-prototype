package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.ihtsdo.otf.tcc.api.concept.ConceptVersionBI;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.api.uuid.UuidT3Generator;

import com.github.jlgrock.snp.core.model.xml.lego.Concept;
import com.github.jlgrock.snp.core.model.xml.lego.Destination;
import com.github.jlgrock.snp.core.model.xml.lego.Expression;
import com.github.jlgrock.snp.core.model.xml.lego.Relation;
import com.github.jlgrock.snp.core.model.xml.lego.Type;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {

    private final Expression expression;

    @Override
    public void create() {
//        String sourceConceptSctid = expression.getConcept().getSctid();
//        int ?? = Integer.parseInt(sourceConceptSctid);

    	String sourceSctId = Optional.ofNullable(expression)
                .map(Expression::getConcept)
                .map(Concept::getSctid)
                .orElse(null);
        if (sourceSctId == null) {
            return;
        }
        
        String isAboutSctId = Optional.ofNullable(expression)
                .map(Expression::getRelations)
                .filter((List<Relation> list) -> list.size() > 0)
                .map((List<Relation> list) -> list.get(0))
                .map(Relation::getType)
                .map(Type::getConcept)
                .map(Concept::getSctid)
                .orElse(null);
        if (isAboutSctId == null) {
            return;
        }

        String destinationSctId = Optional.ofNullable(expression)
                .map(Expression::getRelations)
                .filter((List<Relation> list) -> list.size() > 0)
                .map((List<Relation> list) -> list.get(0))
                .map(Relation::getDestination)
                .map(Destination::getExpression)
                .map(Expression::getConcept)
                .map(Concept::getSctid)
                .orElse(null);
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
        //Create AndNode
        AndNode andNode = And();

        //For LEGO XML expressions, put SufficientSetNode at the top and AndNode next. For "IS ABOUT" type relationship,
        //add RoleNodeSomeWithNids as child of AndNode. For the parameters of RoleNodeSomeWithNids, use typeConceptNid and 
        //ConceptNodeWithNids as parameters.

        root.addChildren(SufficientSet(andNode));
        andNode.addChildren(Concept(sourceConceptNid), SomeRole(typeConceptNid, Concept(destinationNid)));

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
    
    /**
     * Constructor for LogicGraph using input parameters from LEGO XML expressions
     * @param expressionIn the complex expression to parse
     */
    public LegoLogicGraphBuilder(final Expression expressionIn) {
    	expression = expressionIn;
    }
}
