package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface FhirElementProcessorFactory {
    FhirElementProcessorService findClassifier(Object unmarshalledObject) throws ClassifierException;
}
