package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticOrder;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class DiagnosticOrderProcessor extends AbstractFhirProcessor {

    @Inject
    public DiagnosticOrderProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        DiagnosticOrder diagnosticOrder = (DiagnosticOrder) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return DiagnosticOrder.class;
    }

}
