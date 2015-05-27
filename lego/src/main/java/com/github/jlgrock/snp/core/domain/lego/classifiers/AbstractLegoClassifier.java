package com.github.jlgrock.snp.core.domain.lego.classifiers;

import com.github.jlgrock.snp.core.data.ClassifiedPceStore;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import com.github.jlgrock.snp.core.domain.lego.Assertion;
import com.github.jlgrock.snp.core.domain.lego.Destination;
import com.github.jlgrock.snp.core.domain.lego.Discernible;
import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.domain.lego.Pncs;
import com.github.jlgrock.snp.core.domain.lego.Stamp;
import com.github.jlgrock.snp.core.domain.lego.logicgraph.LegoExpressionGraphBuilder;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

import java.util.List;

/**
 *
 */
public abstract class AbstractLegoClassifier implements LegoElementClassifierService {

    private final TerminologyStoreDI terminologyStoreDI;
    private final ClassifiedPceStore classPceStore;

    protected AbstractLegoClassifier(final TerminologyStoreDI terminologyStoreDIIn, 
    		final ClassifiedPceStore classPceStoreIn) {
        terminologyStoreDI = terminologyStoreDIIn;
        classPceStore = classPceStoreIn;
    }

    protected TerminologyStoreDI getTerminologyStoreDI() {
        return terminologyStoreDI;
    }

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

        // Create the logic graph
        LegoExpressionGraphBuilder legoLogicGraphBuilder = new LegoExpressionGraphBuilder(terminologyStoreDI, expression);
        legoLogicGraphBuilder.create();
        LogicGraph logicGraph = legoLogicGraphBuilder;


        //TODO run through classification service, should get a number back.
        ClassifiedPce cPce = new ClassifiedPce();

        //TODO store concept ID, and logic graph expression
        classPceStore.save(cPce);


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
