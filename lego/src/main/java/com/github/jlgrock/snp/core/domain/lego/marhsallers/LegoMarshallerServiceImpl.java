package com.github.jlgrock.snp.core.domain.lego.marhsallers;

import com.github.jlgrock.snp.apis.exceptions.UnmarshallingException;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * Unmarshalls the LEGO XML documents into an object
 */
@Service
@Named
public class LegoMarshallerServiceImpl implements LegoMarshallerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LegoMarshallerServiceImpl.class);

    public static final String LEGO_PACKAGE = "com.github.jlgrock.snp.core.domain.lego";

    /**
     * {@inheritDoc}
     */
    @Override
    public Object unmarshall(final String input) throws UnmarshallingException {
        LOGGER.trace("unmarshalling lego string: {}", input);
        return unmarshall(new StringReader(input));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object unmarshall(final Reader input) throws UnmarshallingException {
        LOGGER.trace("unmarshalling lego reader...");
        Object unmarshalledObject = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(LEGO_PACKAGE);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshalledObject = unmarshaller.unmarshal(input);
            LOGGER.debug("Processing " + unmarshalledObject.getClass().getName());
        } catch (JAXBException e) {
            LOGGER.error("Unmarshalling Error", e);
        }

        return unmarshalledObject;
    }



}
