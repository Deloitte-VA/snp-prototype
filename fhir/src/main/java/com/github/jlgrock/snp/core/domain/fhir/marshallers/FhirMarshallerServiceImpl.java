package com.github.jlgrock.snp.core.domain.fhir.marshallers;

import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Unmarshalls the fhir XML documents into an object
 */
@Service
public class FhirMarshallerServiceImpl implements FhirMarshallerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FhirMarshallerServiceImpl.class);

    public static final java.lang.String FHIR_PACKAGE = "com.github.jlgrock.snp.core.domain.fhir";

    /**
     * {@inheritDoc}
     */
    @Override
    public Object unmarshall(final java.lang.String input) throws UnmarshallingException {
        LOGGER.trace("unmarshalling fhir string: {}", input);
        return unmarshall(new StringReader(input));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object unmarshall(final Reader input) throws UnmarshallingException {
        LOGGER.trace("unmarshalling fhir reader...");
        Object unmarshalledObject = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(FHIR_PACKAGE);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshalledObject = unmarshaller.unmarshal(input);
            LOGGER.debug("Processing " + unmarshalledObject.getClass().getName());
        } catch (JAXBException e) {
            LOGGER.error("Unmarshalling Error", e);
        }
        return unmarshalledObject;
    }
}
