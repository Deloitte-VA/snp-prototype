package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class PatientRepositoryImpl implements PatientRepository {
    @Override
    public List<Patient> findAllByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Patient> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Patient> findAllByDateOfBirth(Date dateOfBirth) {
        return null;
    }

    @Override
    public List<Patient> findAllByGender(Gender gender) {
        return null;
    }

    @Override
    public List<Patient> findAllByRace(Race race) {
        return null;
    }

    @Override
    public Iterable<Patient> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Patient> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Patient> Patient save(S entity) {
        return null;
    }

    @Override
    public <S extends Patient> Iterable<S> save(Iterable<S> entities) {
        return null;
    }

    @Override
    public Patient findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Patient> findAll() {
        return null;
    }

    @Override
    public Iterable<Patient> findAll(Iterable<Long> longs) {
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
    public void delete(Patient entity) {

    }

    @Override
    public void delete(Iterable<? extends Patient> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
