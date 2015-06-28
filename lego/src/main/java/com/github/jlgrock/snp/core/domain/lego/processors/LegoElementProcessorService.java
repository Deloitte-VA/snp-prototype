package com.github.jlgrock.snp.core.domain.lego.processors;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface LegoElementProcessorService {

    void process(Object unmarshalledObject);

    Class processesType();
}
