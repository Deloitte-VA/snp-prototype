package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Units;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class UnitsProcessor extends AbstractLegoProcessor {

    @Inject
    UnitsProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                   final ClassifiedPceRepository classifiedPceRepository) {
        super(logicGraphClassifierIn, classifiedPceRepository);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Units units = (Units) unmarshalledObject;
        throw new UnsupportedOperationException();
    }

    @Override
    public Class processesType() {
        return Units.class;
    }
}
