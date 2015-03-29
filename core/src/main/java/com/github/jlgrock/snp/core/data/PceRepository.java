package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.core.domain.PCE;
import org.jvnet.hk2.annotations.Contract;

import javax.inject.Named;

/**
 * The PCE Repository provides an abstraction layer to executing queries against the PCE
 * Collection within MongoDB.
 */
@Contract
@Named
public interface PceRepository extends MongoRepository<PCE, Long> {
}

