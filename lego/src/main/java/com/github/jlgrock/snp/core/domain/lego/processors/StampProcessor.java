package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.logicgraph.LegoExpressionGraphBuilder;
import com.github.jlgrock.snp.core.domain.lego.model.Stamp;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class StampProcessor extends AbstractLegoProcessor {

    @Inject
    StampProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                   final LegoExpressionGraphBuilder legoExpressionGraphBuilderIn,
                   final ClassifiedPceRepository classifiedPceRepository) {
        super(logicGraphClassifierIn, legoExpressionGraphBuilderIn, classifiedPceRepository);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Stamp stamp = (Stamp) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return Stamp.class;
    }
}
