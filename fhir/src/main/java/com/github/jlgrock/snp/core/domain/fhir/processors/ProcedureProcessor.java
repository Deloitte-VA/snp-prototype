package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Service
public class ProcedureProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureProcessor.class);

    @Inject
    public ProcedureProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        Procedure procedure = (Procedure) unmarshalledObject;
        LOGGER.trace("processing procedure '{}' into observation(s)", procedure);
        //TODO
        throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return Procedure.class;
    }
}
