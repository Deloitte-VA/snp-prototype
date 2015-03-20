package com.github.jlgrock.snp.web.controllers;

import static org.testng.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

/**
 *
 */
public class PatientControllerTest {
	
	@Mock
	Patient patient;
	
	@Spy
	PatientRepository patientRepo = new PatientRepository() {
		
		@Override
		public <S extends Patient> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Patient> Patient save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Patient findOne(Long id) {
			patient.setId(id);
			return patient;
		}
		
		@Override
		public Iterable<Patient> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<Patient> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Page<Patient> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<Patient> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Iterable<? extends Patient> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Patient entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public List<Patient> findAllByRace(Race race) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAllByLastName(String lastName) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAllByGender(Gender gender) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAllByFirstNameAndLastName(String firstName,
				String lastName) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Patient> findAllByDateOfBirth(Date dateOfBirth) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	PatientController patientCntlr = new PatientController(patientRepo);

    @BeforeMethod
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetPatient() {
    	Patient actual = patientCntlr.getPatient(patient.getId());

    	assertEquals(actual, patient);
    }
}
