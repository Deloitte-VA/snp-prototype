package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicalexpression.LegoLogicalExpressionBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.Assertion;
import com.github.jlgrock.snp.core.domain.lego.model.Destination;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;
import com.github.jlgrock.snp.core.domain.lego.model.Expression;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *
 */
public abstract class AbstractLegoProcessor implements LegoElementProcessorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractLegoProcessor.class);

    private final LogicalExpressionClassifier logicalExpressionClassifier;
    private final ClassifiedPceRepository classifiedPceRepository;
    private final LegoLogicalExpressionBuilder legoLogicalExpressionBuilder;

    protected AbstractLegoProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                                    final ClassifiedPceRepository classifiedPceRepositoryIn,
                                    final LegoLogicalExpressionBuilder legoLogicalExpressionBuilderIn) {
        logicalExpressionClassifier = logicalExpressionClassifierIn;
        classifiedPceRepository = classifiedPceRepositoryIn;
        legoLogicalExpressionBuilder = legoLogicalExpressionBuilderIn;
    }

    protected void processLegoList(final LegoList legoListIn) {
        List<Lego> legoList = legoListIn.getLego();
        for (Lego lego : legoList) {
            processLego(lego);
        }
    }

    protected void processLego(final Lego lego) {
        List<Assertion> assertionList = lego.getAssertion();
        for (Assertion assertion : assertionList) {
            processAssertion(assertion);
        }

        Pncs pncs = lego.getPncs();
        processPncs(pncs);
        Stamp stamp = lego.getStamp();
        processStamp(stamp);
    }

    protected void processAssertion(final Assertion assertion) {
        Discernible discernible = assertion.getDiscernible();
        if (discernible != null) {
            processDiscernible(discernible);
        }
    }

    protected void processDiscernible(final Discernible discernible) {
        Expression expression = discernible.getExpression();
        if (expression != null) {
            processExpression(expression);
        }
    }

    protected void processExpression(final Expression expression) {
        // Create the logic graph
        LogicalExpression logicalExpression = legoLogicalExpressionBuilder.build(expression);
        LOGGER.debug("executing classifier logic on logic graph...");
        Integer classifiedLogicGraphId = logicalExpressionClassifier.classify(logicalExpression);
        LOGGER.debug("received id: {}", classifiedLogicGraphId);

        ClassifiedPce cPce = new ClassifiedPce();
        cPce.setNid(classifiedLogicGraphId.intValue());
        cPce.setDesc(logicalExpression.toString());

        classifiedPceRepository.save(cPce);
    }

    protected void processPncs(final Pncs pncs) {
        //Do nothing?
    }

    protected void processStamp(final Stamp stamp) {
        //Do nothing?
    }

    protected void processDestination(final Destination destination) {
        Expression expression = destination.getExpression();
        processExpression(expression);
    }


}
