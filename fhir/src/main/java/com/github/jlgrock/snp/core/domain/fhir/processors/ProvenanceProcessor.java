package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Provenance;

/**
 *
 */
public class ProvenanceProcessor extends AbstractFhirProcessor {

    private final Provenance provenance;

    public ProvenanceProcessor(final LogicGraphClassifier logicGraphClassifierIn, final Provenance provenanceIn) {
        super(logicGraphClassifierIn);
        provenance = provenanceIn;
    }

	@Override
	public void process(final String identifier) {
		throw new UnsupportedOperationException();
		
	}
}
