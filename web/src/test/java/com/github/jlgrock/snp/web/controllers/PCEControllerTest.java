package com.github.jlgrock.snp.web.controllers;

import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.data.PceRepository;
import com.github.jlgrock.snp.core.domain.PCE;

/**
 *
 */
public class PCEControllerTest {
	
	@Mock
	private PCE pce;
	
	@Mock
	private PceRepository pceRepo;
	
	private PceController pceCntlr;
	
    @BeforeMethod
    public void setUp() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetPce() {
    	Mockito.when(pceRepo.findOne(pce.getId())).thenReturn(pce);
    	pceCntlr = new PceController(pceRepo);
    	PCE actual = pceCntlr.getPce(pce.getId());

    	assertEquals(actual, pce);
    }
}
