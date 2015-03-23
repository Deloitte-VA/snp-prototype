package com.github.jlgrock.snp.web.controllers;

import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Patient;

/**
 *
 */
public class PatientControllerTest {
	
	@Mock
	Patient patient;

	@Mock
	PatientRepository patientRepo;
	
	private PatientController patientCntlr;

    @BeforeMethod
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetPatient() {
    	Mockito.when(patientRepo.findOne(patient.getId())).thenReturn(patient);
    	patientCntlr = new PatientController(patientRepo);
    	Patient actual = patientCntlr.getPatient(patient.getId());

    	assertEquals(actual, patient);
    }
}
