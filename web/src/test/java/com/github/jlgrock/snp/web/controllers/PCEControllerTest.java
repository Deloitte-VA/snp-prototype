package com.github.jlgrock.snp.web.controllers;

import static org.testng.Assert.assertEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.data.PceRepository;
import com.github.jlgrock.snp.core.domain.PCE;

/**
 *
 */
public class PCEControllerTest {
	
	@Mock
	PCE pce;
	
	@Spy
	PceRepository pceRepo = new PceRepository() {
		
		@Override
		public <S extends PCE> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends PCE> PCE save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public PCE findOne(Long id) {
			pce.setId(id);
			return pce;
		}
		
		@Override
		public Iterable<PCE> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<PCE> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Page<PCE> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<PCE> findAll(Sort sort) {
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
		public void delete(Iterable<? extends PCE> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(PCE entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	PceController pceCntlr = new PceController(pceRepo);
	
    @BeforeMethod
    public void setUp() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetPce() {
    	PCE actual = pceCntlr.getPce(pce.getId());

    	assertEquals(actual, pce);
    }
}
