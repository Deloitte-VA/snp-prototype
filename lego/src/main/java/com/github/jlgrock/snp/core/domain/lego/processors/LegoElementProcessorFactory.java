package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface LegoElementProcessorFactory {
    LegoElementProcessorService findElementProcessor(Object unmarshalledObject) throws ClassifierException;
}
