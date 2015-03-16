package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.domain.PCE;

/**
 *
 */
public class PCERepositoryImpl implements PCERepository {
    @Override
    public Iterable<PCE> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PCE> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PCE> PCE save(S entity) {
        return null;
    }

    @Override
    public <S extends PCE> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public PCE findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<PCE> findAll() {
        return null;
    }

    @Override
    public Iterable<PCE> findAll(Iterable<Long> longs) {
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
    public void delete(PCE entity) {

    }

    @Override
    public void delete(Iterable<? extends PCE> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
