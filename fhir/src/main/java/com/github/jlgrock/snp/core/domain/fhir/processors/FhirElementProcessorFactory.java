package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.jvnet.hk2.annotations.Contract;

/**
 * The factory interface for finding a specific processing service to handle an unmarshalled FHIR XML object.
 */
@Contract
public interface FhirElementProcessorFactory {

    /**
     * Finds the appropriate processing service from the object passed in
     * @param unmarshalledObject the object that has been unmarshalled using JAXb
     * @return the appropriate processor to handle the object
     * @throws ClassifierException if there is any problem identifying the object
     */
    FhirElementProcessorService findProcessingService(Object unmarshalledObject) throws ClassifierException;
}
