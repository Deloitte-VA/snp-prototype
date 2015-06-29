package com.github.jlgrock.snp.core.domain.fhir.processors;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface FhirElementProcessorService {
    void process(final String identifier, final Object unmarshalledObject);

    Class processesType();
}
