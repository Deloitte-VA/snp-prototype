package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author jlgrock
 *
 */
public interface PatientRepository extends MongoRepository<Patient, Long> {
	/**
	 * 
	 * @param lastName is a string of the last name
	 * @return list of patients
	 */
    List<Patient> findAllByLastName(String lastName);
    /**
     * 
     * @param firstName is a string of the first name 
     * @param lastName is a string of the last name
     * @return list of patients
     */
    List<Patient> findAllByFirstNameAndLastName(String firstName, String lastName);
    /**
     * 
     * @param dateOfBirth is the birthday date
     * @return list of patients
     */
    List<Patient> findAllByDateOfBirth(Date dateOfBirth);
    /**
     * 
     * @param gender is the gender
     * @return list of patients
     */
    List<Patient> findAllByGender(Gender gender);
    /**
     * 
     * @param race is the patient's race
     * @return list of patients
     */
    List<Patient> findAllByRace(Race race);
}

