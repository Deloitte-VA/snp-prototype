package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Pncs;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class PncsProcessor extends AbstractLegoProcessor {

    @Inject
    PncsProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                  final ClassifiedPceRepository classifiedPceRepository) {
        super(logicGraphClassifierIn, classifiedPceRepository);
    }

    @Override
    public void process(final Object unmarshalledObject) {
        Pncs pncs = (Pncs) unmarshalledObject;
        processPncs(pncs);
    }

    @Override
    public Class processesType() {
        return Pncs.class;
    }
}
