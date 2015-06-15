package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.data.MongoRepository;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.jvnet.hk2.annotations.Contract;

import java.time.LocalDate;
import java.util.List;

/**
 * 
 * The Patient Repository provides an abstraction layer to executing queries against the Patient 
 * Collection within MongoDB. 
 *
 */
@Contract
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
    List<Patient> findAllByDateOfBirth(LocalDate dateOfBirth);
    /**
     * 
     * @param gender is the gender
     * @return list of patients
     */
    List<Patient> findAllByGender(Gender gender);
}


