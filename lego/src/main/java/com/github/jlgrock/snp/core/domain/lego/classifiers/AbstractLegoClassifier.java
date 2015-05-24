package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Destination;
import com.github.jlgrock.snp.core.domain.lego.Discernible;
import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.domain.lego.Pncs;
import com.github.jlgrock.snp.core.domain.lego.Stamp;
import com.github.jlgrock.snp.core.domain.lego.logicgraph.ExpressionGraphBuilder;
import gov.vha.isaac.logic.LogicGraph;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public abstract class AbstractLegoClassifier implements LegoElementClassifierService {
    protected void parseLegoList(final LegoList legoListIn) {
        List<Lego> legoList = legoListIn.getLego();
        for (Lego lego : legoList) {
            parseLego(lego);
        }
    }

    protected void parseLego(final Lego lego) {
        List<Assertion> assertionList = lego.getAssertion();
        for (Assertion assertion : assertionList) {
            parseAssertion(assertion);
        }

        Pncs pncs = lego.getPncs();
        parsePncs(pncs);
        Stamp stamp = lego.getStamp();
        parseStamp(stamp);
    }

    protected void parseAssertion(final Assertion assertion) {
        Discernible discernible = assertion.getDiscernible();
        parseDiscernible(discernible);
    }

    protected void parseDiscernible(final Discernible discernible) {
        Expression expression = discernible.getExpression();
        parseExpression(expression);
    }

    protected void parseExpression(final Expression expression) {
        ExpressionGraphBuilder legoLogicGraphBuilder = new ExpressionGraphBuilder().expression(expression);
        LogicGraph logicGraph = (LogicGraph)legoLogicGraphBuilder;

        //TODO run through classification service, should get a number back.
        UUID uuid = UUID.randomUUID();
        int conceptId = -2;

        //TODO store concept ID, and logic graph expression


    }

    protected void parsePncs(final Pncs pncs) {
        //Do nothing?
    }

    protected void parseStamp(final Stamp stamp) {
        //Do nothing?
    }

    protected void parseDestination(final Destination destination) {
        Expression expression = destination.getExpression();
        parseExpression(expression);
    }
}
