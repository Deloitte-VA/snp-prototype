package com.github.jlgrock.snp.core.domain.lego.processors;

import org.jvnet.hk2.annotations.Contract;

/**
 * Interface to define how to process a FHIR element that is unmarshalled from a FHIR XML document.
 */
@Contract
public interface LegoElementProcessorService {

    /**
     * Process the fhir element
     * @param unmarshalledObject the object that was unmarshalled.  This should be inspected before sending it so that
     *                           the fhir element will be guaranteed of the expected type (though it will need to be
     *                           casted)
     */
    void process(Object unmarshalledObject);

    /**
     * @return the type that this is expecting
     */
    Class processesType();
}
