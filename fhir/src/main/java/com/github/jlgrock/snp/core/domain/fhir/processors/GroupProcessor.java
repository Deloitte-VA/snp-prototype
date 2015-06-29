package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Group;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class GroupProcessor extends AbstractFhirProcessor {

    @Inject
    public GroupProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Group group = (Group) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return Group.class;
    }
}
