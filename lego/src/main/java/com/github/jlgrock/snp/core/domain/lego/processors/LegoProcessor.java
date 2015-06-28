package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class LegoProcessor extends AbstractLegoProcessor {

    @Inject
    LegoProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                  final ClassifiedPceStore classPceStore) {
        super(logicGraphClassifierIn, classPceStore);
    }

    @Override
	public void process(final Object unmarshalledObject) {
        Lego lego = (Lego) unmarshalledObject;
        processLego(lego);
    }

    @Override
    public Class processesType() {
        return Lego.class;
    }
}
