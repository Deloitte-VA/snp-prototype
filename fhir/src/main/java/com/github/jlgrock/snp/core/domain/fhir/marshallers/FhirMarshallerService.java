package com.github.jlgrock.snp.core.domain.fhir.marshallers;

import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;

import java.io.Reader;

/**
 *
 */
public interface FhirMarshallerService {
    public Object unmarshall(final String input) throws UnmarshallingException;

    public Object unmarshall(final Reader input) throws UnmarshallingException;
}
