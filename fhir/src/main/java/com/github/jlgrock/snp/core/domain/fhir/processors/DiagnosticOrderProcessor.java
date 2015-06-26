package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticOrder;

/**
 *
 */
public class DiagnosticOrderProcessor extends AbstractFhirProcessor {

    private final DiagnosticOrder diagnosticOrder;

    public DiagnosticOrderProcessor(final LogicGraphClassifier logicGraphClassifierIn, final DiagnosticOrder diagnosticOrderIn) {
        super(logicGraphClassifierIn);
        diagnosticOrder = diagnosticOrderIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}

}
