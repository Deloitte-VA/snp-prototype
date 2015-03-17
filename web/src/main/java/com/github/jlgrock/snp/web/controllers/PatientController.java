package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    @Produces("application/json")
    public String getPatient(@PathParam("id") final Long id) {
        LOGGER.debug("getting encounter");
        return "{\"patient\": \"example\", \"id\":" + id + "}";
//        return repository.findOne(id);
    }
}

