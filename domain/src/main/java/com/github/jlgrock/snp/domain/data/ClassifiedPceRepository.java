package com.github.jlgrock.snp.domain.data;

import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;

/**
 * The Assertion Repository provides an abstraction layer to executing queries against the Assertion
 * Collection within MongoDB.
 */
@Contract
public interface ClassifiedPceRepository extends MongoRepository<ClassifiedPce, ObjectId> {
}

