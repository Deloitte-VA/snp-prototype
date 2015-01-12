package com.deloitte.mongo.data;

import com.deloitte.mongo.domain.PCE;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jlgrock on 1/11/15.
 */
public interface PCERepository extends MongoRepository<PCE, Long> {
}
