package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.Encounter;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class EncounterRepositoryImpl extends AbstractRepositoryImpl<Encounter, Long> implements EncounterRepository {

    @Override
    public List<Encounter> findByDate(Date date) {
        return null;
    }

}
