package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class ProcedureProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureProcessor.class);

    private final Procedure procedure;

    public ProcedureProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                              final Procedure procedureIn) {
        super(logicGraphClassifierIn);
        procedure = procedureIn;
    }

	@Override
	public void process(final String identifier) {
        LOGGER.trace("processing procedure into observation");
		throw new UnsupportedOperationException();
		
	}
}
