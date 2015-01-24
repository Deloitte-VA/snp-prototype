package com.deloitte.mongo.data;

import com.deloitte.mongo.domain.Encounter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface EncounterRepository extends MongoRepository<Encounter, Long> {

    public List<Encounter> findByDate(Date date);
    //public List<Encounter> findByPatientId(Long id);

    //@Query("'$or':[{'firstName':{'$regex':?0,'$options':'i'}},{'lastName':{'$regex':?0,'$options':'i'}}]")
    //List<User> findByEmailOrFirstnameOrLastnameLike(String searchText);
}
