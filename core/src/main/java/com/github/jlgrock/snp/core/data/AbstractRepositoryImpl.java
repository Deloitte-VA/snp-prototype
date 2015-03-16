package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;

import java.io.Serializable;

/**
 *
 */
public abstract class AbstractRepositoryImpl<S, T extends Serializable> implements MongoRepository<S, T> {


    @Override
    public Iterable<S> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<S> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S1 extends S> S save(S1 entity) {
        return null;
    }

    @Override
    public <S1 extends S> Iterable<S1> save(Iterable<S1> entities) {
        return null;
    }

    @Override
    public S findOne(T t) {
        return null;
    }

    @Override
    public boolean exists(T t) {
        return false;
    }

    @Override
    public Iterable<S> findAll() {
        return null;
    }

    @Override
    public Iterable<S> findAll(Iterable<T> ts) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(T t) {

    }

    @Override
    public void delete(S entity) {

    }

    @Override
    public void delete(Iterable<? extends S> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
