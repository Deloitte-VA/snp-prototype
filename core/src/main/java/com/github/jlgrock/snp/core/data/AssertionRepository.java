package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.core.domain.Assertion;

/**
 * The PCE Repository provides an abstraction layer to executing queries against the PCE
 * Collection within MongoDB.
 */
public interface AssertionRepository extends MongoRepository<Assertion, Long> {
}

