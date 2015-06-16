package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import org.jvnet.hk2.annotations.Contract;

import java.time.LocalDate;
import java.util.List;

/**
 * The Encounter Repository provides an abstraction layer to executing queries against the Encounter
 * Collection within MongoDB.
 */
@Contract
public interface EncounterRepository extends MongoRepository<Encounter, Long> {
    /**
     * This function finds a list of encounters on a particular date
     *
     * @param date parameter of type Date
     * @return list of encounters
     */
    List<Encounter> findByDate(LocalDate date);
    //public List<Encounter> findByPatientId(Long id);

    //@Query("'$or':[{'firstName':{'$regex':?0,'$options':'i'}},{'lastName':{'$regex':?0,'$options':'i'}}]")
    //List<User> findByEmailOrFirstnameOrLastnameLike(String searchText);

    /**
     * Find all of the Encounters based off of whether they have had an observed PCE observation
     * @param pceIds the pce ids to find in the observation sub-object
     * @return a list of the encounters that match the criteria
     */
    List<Encounter> findByPceIdList(List<Long> pceIds);
}

