package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.LogicGraphBuilder;
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

import com.github.jlgrock.snp.core.model.parser.Concept;
import com.github.jlgrock.snp.core.model.parser.Destination;
import com.github.jlgrock.snp.core.model.parser.Expression;
import com.github.jlgrock.snp.core.model.parser.Relation;
import com.github.jlgrock.snp.core.model.parser.Type;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {

    private final Expression expression;

    @Override
    public void create() {
//        String sourceConceptSctid = expression.getConcept().getSctid();
//        int ?? = Integer.parseInt(sourceConceptSctid);

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
        
        int typeConceptNid = 0;
        int destinationNid = 0;
        TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);
        try {
            TerminologySnapshotDI termSnapshot = termStore.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());
            
            //UUID bleedingSnomedUuid = UuidT3Generator.fromSNOMED(131148009L);
            //TODO: Verify if there is a way to use lookup
            UUID typeConceptUuid = UuidT3Generator.fromSNOMED(Integer.parseInt(isAboutSctId));
            UUID destinationUuid = UuidT3Generator.fromSNOMED(Integer.parseInt(destinationSctId));
            
            ConceptVersionBI typeConcept = termSnapshot.getConceptVersion(typeConceptUuid);
            ConceptVersionBI destinationConcept = termSnapshot.getConceptVersion(destinationUuid);
            
            typeConceptNid = typeConcept.getNid();
            destinationNid =  destinationConcept.getNid();
        } catch (IOException ex) {
            //Logger.getLogger(LegoLogicGraphBuilder.class.getName()).log(Level.SEVERE, null, ex);
        	ex.printStackTrace();
        }

        RootNode root = Root(SufficientSet(And(SomeRole(typeConceptNid, Concept(destinationNid)))));

    }
    
    /**
     * Constructor for LogicGraph using input parameters from LEGO XML expressions
     * @param expressionIn the complex expression to parse
     */
    public LegoLogicGraphBuilder(final Expression expressionIn) {
    	expression = expressionIn;
    }
}
