package com.github.jlgrock.snp.web.controllers;

import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.data.EncounterRepository;
import com.github.jlgrock.snp.core.domain.Encounter;
/**
 *
 */
public class EncounterControllerTest {
	
	@Mock
	private Encounter encounter;
	
	@Mock
	private EncounterRepository encntrRepo;

    private EncounterController encntrCntlr;
	
    @BeforeMethod
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
        
    }
    
    @Test
    public void testGetEncounter() {
    	
    	Mockito.when(encntrRepo.findOne(encounter.getId())).thenReturn(encounter);
    	encntrCntlr = new EncounterController(encntrRepo);
    	Encounter actual = encntrCntlr.getEncounter(encounter.getId());

    	assertEquals(actual, encounter);
    }

}

