package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicalexpression.LegoLogicalExpressionBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class LegoListProcessor extends AbstractLegoProcessor {

    @Inject
    LegoListProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn,
                      final ClassifiedPceRepository classifiedPceRepositoryIn,
                      final LegoLogicalExpressionBuilder legoLogicalExpressionBuilderIn) {
        super(logicalExpressionClassifierIn, classifiedPceRepositoryIn, legoLogicalExpressionBuilderIn);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        LegoList legoList = (LegoList) unmarshalledObject;
        processLegoList(legoList);
    }

    @Override
    public Class processesType() {
        return LegoList.class;
    }
}
