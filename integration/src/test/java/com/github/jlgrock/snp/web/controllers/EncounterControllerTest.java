package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.apis.data.Page;
import com.github.jlgrock.snp.apis.data.Pageable;
import com.github.jlgrock.snp.apis.data.Sort;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.web.ApplicationConfig;
import com.github.jlgrock.snp.web.ApplicationObjectMapper;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.test.JerseyTestNg;
import org.glassfish.jersey.test.TestProperties;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;
/**
 *
 */
public class EncounterControllerTest extends JerseyTestNg.ContainerPerClassTest {
	
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
			Encounter encounter = new Encounter();
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

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(new JacksonFeature()).register(ApplicationObjectMapper.class);
    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        //return all of the rest endpoints
        return ApplicationConfig.createApp();
    }

    @Test
    public void testFindById() {
        final Long id = 1L;
//        final Long patientId = 2l;
//        final int type = 9;
//        final String reason = "stuff";
//        final Encounter e = new Encounter();
//        e.setId(id);
//        e.setDate(LocalDate.now());
//        e.setPatientId(patientId);
//        e.setReasonForVisit(reason);
//        e.setType(type);
        final String response = target("encounter/" + id).request().get(String.class);
//        final String converted = new EncounterWriteConverter(mock(ObservationWriteConverter.class)).
//                convert(e).toString();
        final String converted = "{\r\n  \"id\" : 1,\r\n  \"patientId\" : null,\r\n  \"date\" : null,\r\n  \"type\" : null,\r\n  \"reasonForVisit\" : null,\r\n  \"observations\" : null\r\n}";
        assertEquals(response, converted);
    }
}

