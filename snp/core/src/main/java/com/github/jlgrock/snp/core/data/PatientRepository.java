package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * The Patient Repository provides an abstraction layer to executing queries against the Patient
 * Collection within MongoDB.
 */
public interface PatientRepository extends MongoRepository<Patient, Long> {
    List<Patient> findAllByLastName(String lastName);
    List<Patient> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<Patient> findAllByDateOfBirth(Date dateOfBirth);
    List<Patient> findAllByGender(Gender gender);
    List<Patient> findAllByRace(Race race);
}

