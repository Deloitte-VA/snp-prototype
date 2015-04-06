package com.github.jlgrock.snp.core.data;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;

/**
 * The Assertion Repository provides an abstraction layer to executing queries against the Assertion
 * Collection within MongoDB.
 */
@Contract
public interface ClassifiedAssertionRepository extends MongoRepository<ClassifiedAssertion, Long> {
}

