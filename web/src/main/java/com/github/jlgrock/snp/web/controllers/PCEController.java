package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.PCERepository;
import com.github.jlgrock.snp.core.domain.PCE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * The Controller serving up domain objects for PCE objects.
 */
@Path("/pce")
public class PCEController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PCEController.class);


//    private PCERepository repository;

//    @Inject
//    public PCEController(final PCERepository repositoryIn) {
//        repository = repositoryIn;
//    }

    /**
     * get a single PCE.
     *
     * @param id the id of the PCE to get
     * @return the PCE to return to the client
     */
    @GET @Path("/{id}")
    @Produces("application/json")
    public String getPCE(@PathParam("id") final Long id) {
        LOGGER.debug("getting encounter");
        return "{\"pce\": \"example\", \"id\":" + id + "}";
//        return repository.findOne(id);
    }
}
