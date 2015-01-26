package com.deloitte.mongo.data;

import com.deloitte.mongo.domain.Gender;
import com.deloitte.mongo.domain.Patient;
import com.deloitte.mongo.domain.Race;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface PatientRepository extends MongoRepository<Patient, Long> {
    public List<Patient> findAllByLastName(String lastName);
    public List<Patient> findAllByFirstNameAndLastName(String firstName, String lastName);
    public List<Patient> findAllByDob(Date dob);
    public List<Patient> findAllByGender(Gender gender);
    public List<Patient> findAllByRace(Race race);
}
