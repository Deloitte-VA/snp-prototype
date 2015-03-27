package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

import java.util.Date;
import java.util.List;

/**
 *
 */
public class PatientRepositoryImpl extends AbstractRepositoryImpl<Patient, Long> implements PatientRepository {
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

}
