package com.github.jlgrock.snp.core.domain.lego.marhsallers;

import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import org.jvnet.hk2.annotations.Contract;

import java.io.Reader;

/**
 * A Service for unmarshalling Lego XML to Java Objects.
 */
@Contract
public interface LegoMarshallerService {

    /**
     * The package where the lego objects have been generated using JAXb.
     */
    String LEGO_PACKAGE = "com.github.jlgrock.snp.core.domain.lego.model";

    /**
     * Unmarshall an XML string to java objects.  Return the Specific Lego Object created.  Note that this will need
     * to be cast to the appropriate object.
     * @param input the String input to parse
     * @return the Lego Object that was created
     * @throws UnmarshallingException any exceptions that happened during the unmarshalling
     */
    Object unmarshall(final String input) throws UnmarshallingException;

    /**
     * Unmarshall an XML reader to java objects.  Return the Specific Lego Object created.  Note that this will need
     * to be cast to the appropriate object.
     * @param input the input reader to parse
     * @return the Lego Object that was created
     * @throws UnmarshallingException any exceptions that happened during the unmarshalling
     */
    Object unmarshall(final Reader input) throws UnmarshallingException;
}
