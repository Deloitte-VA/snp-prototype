package com.github.jlgrock.snp.web.controllers;

//import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The Controller serving up domain objects for Patient objectsØ.
 */

@Path("/patient")
public class PatientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

//    private PatientRepository repository;
//
//    @Inject
//    public PatientController(final PatientRepository repositoryIn) {
//        repository = repositoryIn;
//    }

    /** 
     * @param id used to find encounter
     * @return single encounter that corresponds to id
     */
    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam("id") final Long id) {
        LOGGER.debug("getting encounter");
        final Patient p = new Patient();
        p.setId(id);
        p.setFirstName("abc");
        p.setMiddleName("def");
        p.setLastName("ghi");
        p.setGender(Gender.FEMALE);
        p.setRace(Race.AMERICAN_INDIAN);
        return p;
//        return "{\"patient\": \"example\", \"id\":" + id + "}";
//        return repository.findOne(id);
    }
}

