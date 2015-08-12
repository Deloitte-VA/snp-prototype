package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.ValueSet;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ValueSetProcessor extends AbstractFhirProcessor {

    @Inject
    public ValueSetProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        ValueSet valueSet = (ValueSet) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return ValueSet.class;
    }
}
