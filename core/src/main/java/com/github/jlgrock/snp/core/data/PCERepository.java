package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.PCE;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The PCE Repository provides an abstraction layer to executing queries against the PCE
 * Collection within MongoDB.
 */
public interface PCERepository extends MongoRepository<PCE, Long> {
}

