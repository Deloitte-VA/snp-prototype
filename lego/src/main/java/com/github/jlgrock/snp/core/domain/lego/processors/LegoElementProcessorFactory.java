package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.jvnet.hk2.annotations.Contract;

/**
 * The factory interface for finding a specific processing service to handle an unmarshalled Lego XML object.
 */
@Contract
public interface LegoElementProcessorFactory {

    /**
     * Finds the appropriate processing service from the object passed in
     * @param unmarshalledObject the object that has been unmarshalled using JAXb
     * @return the appropriate processor to handle the object
     * @throws ClassifierException if there is any problem identifying the object
     */
    LegoElementProcessorService findElementProcessor(Object unmarshalledObject) throws ClassifierException;
}
