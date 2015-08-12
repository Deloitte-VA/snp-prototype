package com.github.jlgrock.snp.core.domain.fhir.marshallers;

import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import org.jvnet.hk2.annotations.Contract;

import java.io.Reader;

/**
 * A Service for unmarshalling FHIR XML to Java Objects.
 */
@Contract
public interface FhirMarshallerService {
    /**
     * The package where the fhir objects have been generated using JAXb.
     */
    String FHIR_PACKAGE = "com.github.jlgrock.snp.core.domain.fhir.model";

    /**
     * Unmarshall an XML string to java objects.  Return the Specific FHIR Object created.  Note that this will need
     * to be cast to the appropriate object.
     * @param input the String input to parse
     * @return the FHIR Object that was created
     * @throws UnmarshallingException any exceptions that happened during the unmarshalling
     */
    public Object unmarshall(final String input) throws UnmarshallingException;

    /**
     * Unmarshall an XML reader to java objects.  Return the Specific FHIR Object created.  Note that this will need
     * to be cast to the appropriate object.
     * @param input the input reader to parse
     * @return the FHIR Object that was created
     * @throws UnmarshallingException any exceptions that happened during the unmarshalling
     */
    public Object unmarshall(final Reader input) throws UnmarshallingException;
}
