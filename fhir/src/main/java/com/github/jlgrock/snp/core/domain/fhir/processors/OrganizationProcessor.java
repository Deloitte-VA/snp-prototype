package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Organization;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class OrganizationProcessor extends AbstractFhirProcessor {

    @Inject
    public OrganizationProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Organization orgazation = (Organization) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Organization.class;
    }
}
