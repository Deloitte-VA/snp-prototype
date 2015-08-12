package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicalexpression.LegoLogicalExpressionBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.Discernible;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class DiscernibleProcessor extends AbstractLegoProcessor {

    @Inject
    DiscernibleProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                         final ClassifiedPceRepository classifiedPceRepositoryIn,
                         final LegoLogicalExpressionBuilder legoLogicalExpressionBuilderIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn, legoLogicalExpressionBuilderIn);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Discernible discernible = (Discernible) unmarshalledObject;
        processDiscernible(discernible);
    }

    @Override
    public Class processesType() {
        return Discernible.class;
    }
}
