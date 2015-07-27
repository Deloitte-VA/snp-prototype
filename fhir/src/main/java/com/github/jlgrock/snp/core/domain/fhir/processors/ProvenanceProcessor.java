package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Provenance;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class ProvenanceProcessor extends AbstractFhirProcessor {

    @Inject
    public ProvenanceProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Provenance provenance = (Provenance) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Provenance.class;
    }
}
