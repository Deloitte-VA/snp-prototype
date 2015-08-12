package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 * The processor used for handling RelatedPerson objects unmarshalled from FHIR XML.
 */
@Service
public class RelatedPersonProcessor extends AbstractFhirProcessor {

    @Inject
    public RelatedPersonProcessor(final LogicalExpressionClassifier logicalExpressionClassifierIn) {
        super(logicalExpressionClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        RelatedPerson relatedPerson = (RelatedPerson) unmarshalledObject;
		throw new UnsupportedOperationException();
		
	}

    @Override
    public Class processesType() {
        return RelatedPerson.class;
    }
}
