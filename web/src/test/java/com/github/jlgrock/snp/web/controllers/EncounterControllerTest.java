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
import com.github.jlgrock.snp.core.data.EncounterRepository;
import com.github.jlgrock.snp.core.domain.Encounter;
/**
 *
 */
public class EncounterControllerTest {
	
	@Mock
	Encounter encounter;	
	
	@Spy
	EncounterRepository encntrRepo = new EncounterRepository() {
		
		@Override
		public <S extends Encounter> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Encounter> Encounter save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Encounter findOne(Long id) {
	        encounter.setId(id);
	        return encounter;
		}
		
		@Override
		public Iterable<Encounter> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<Encounter> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Page<Encounter> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<Encounter> findAll(Sort sort) {
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
		public void delete(Iterable<? extends Encounter> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Encounter entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public List<Encounter> findByDate(Date date) {
			// TODO Auto-generated method stub
			return null;
		}
	};

    EncounterController encntrCntlr = new EncounterController(encntrRepo);
	
    @BeforeMethod
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
        
    }
    
    @Test
    public void testGetEncounter() {
    	Encounter actual = encntrCntlr.getEncounter(encounter.getId());

    	assertEquals(actual, encounter);
    }

}

