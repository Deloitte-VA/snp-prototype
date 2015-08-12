package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.jvnet.hk2.annotations.Contract;

/**
 * The factory interface for finding a specific processing service to handle an unmarshalled FHIR XML object.
 */
@Contract
public interface FhirElementProcessorFactory {
    FhirElementProcessorService findProcessingService(Object unmarshalledObject) throws ClassifierException;
}
