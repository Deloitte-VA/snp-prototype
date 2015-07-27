package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Substance;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class SubstanceProcessor extends AbstractFhirProcessor {

    @Inject
    public SubstanceProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Substance substance = (Substance) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return Substance.class;
    }
}
