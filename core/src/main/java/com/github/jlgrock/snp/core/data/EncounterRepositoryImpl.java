package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.domain.Encounter;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class EncounterRepositoryImpl implements EncounterRepository {
    @Override
    public List<Encounter> findByDate(Date date) {
        return null;
    }

    @Override
    public Iterable<Encounter> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Encounter> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Encounter> Encounter save(S entity) {
        return null;
    }

    @Override
    public <S extends Encounter> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Encounter findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Encounter> findAll() {
        return null;
    }

    @Override
    public Iterable<Encounter> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Encounter entity) {

    }

    @Override
    public void delete(Iterable<? extends Encounter> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
