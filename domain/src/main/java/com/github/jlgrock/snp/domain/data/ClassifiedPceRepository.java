package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.jvnet.hk2.annotations.Contract;

/**
 * The Assertion Repository provides an abstraction layer to executing queries against the Assertion
 * Collection within MongoDB.
 */
@Contract
public interface ClassifiedPceRepository extends MongoRepository<ClassifiedPce, Integer> {
}

