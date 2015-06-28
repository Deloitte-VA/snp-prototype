package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import com.github.jlgrock.snp.domain.data.ClassifiedPceStore;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class LegoListProcessor extends AbstractLegoProcessor {

    @Inject
    LegoListProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                      final ClassifiedPceStore classPceStore) {
        super(logicGraphClassifierIn, classPceStore);
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
