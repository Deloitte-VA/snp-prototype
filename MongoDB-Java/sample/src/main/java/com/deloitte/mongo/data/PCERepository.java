package com.deloitte.mongo.data;

import com.deloitte.mongo.domain.PCE;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 */
public interface PCERepository extends MongoRepository<PCE, Long> {
}
