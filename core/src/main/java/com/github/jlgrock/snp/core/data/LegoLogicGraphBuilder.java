package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.model.parser.Concept;
import com.github.jlgrock.snp.core.model.parser.Destination;
import com.github.jlgrock.snp.core.model.parser.Expression;
import com.github.jlgrock.snp.core.model.parser.Relation;
import com.github.jlgrock.snp.core.model.parser.Type;
import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicGraphBuilder;
import gov.vha.isaac.logic.node.RootNode;
import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * A Logic Graph Builder specific to Lego documents.  This should only be used to
 */
public class LegoLogicGraphBuilder extends LogicGraphBuilder {

    private final Expression expression;
    private LogicGraph logicGraph;

    @Override
    public void create() {
//        String sourceConceptSctid = expression.getConcept().getSctid();
//        int ?? = Integer.parseInt(sourceConceptSctid);

        String isAboutSctId = Optional.ofNullable(expression)
                .map(Expression::getRelations)
                .filter((List<Relation> list) -> list.size() < 0)
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
                .filter((List<Relation> list) -> list.size() < 0)
                .map((List<Relation> list) -> list.get(0))
                .map(Relation::getDestination)
                .map(Destination::getExpression)
                .map(Expression::getConcept)
                .map(Concept::getSctid)
                .orElse(null);
        if (destinationSctId == null) {
            return;
        }

        int typeConceptNid = Integer.parseInt(isAboutSctId);
        int destinationNid = Integer.parseInt(destinationSctId);

        RootNode root = Root(SufficientSet(And(SomeRole(typeConceptNid, Concept(destinationNid)))));
        
    }

    public LogicGraph getLogicGraph() {
        return logicGraph;
    }
    
    /**
     * Constructor for LogicGraph using input parameters from LEGO XML expressions
     * @param expressionIn
     * @throws IOException
     * @throws ContradictionException
     */
    public LegoLogicGraphBuilder(final Expression expressionIn) throws IOException, ContradictionException {
    	expression = expressionIn;
    }
}
