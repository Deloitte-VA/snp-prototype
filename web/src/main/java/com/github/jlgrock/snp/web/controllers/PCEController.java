package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.PCERepository;
import com.github.jlgrock.snp.core.domain.PCE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * The Controller serving up domain objects for PCE objects.
 */
//@RestController
//@RequestMapping("/pce")
@Path("/pce")
public class PCEController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PCEController.class);


    private PCERepository repository;

    @Inject
    public PCEController(final PCERepository repositoryIn) {
        repository = repositoryIn;
    }

    /**
     * get a single PCE.
     *
     * @param id the id of the PCE to get
     * @return the PCE to return to the client
     */
    @GET @Path("/{id}")
    @Produces("application/json")
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
    public PCE getPCE(@PathParam("id") final Long id) {
        LOGGER.debug("getting encounter");
        return repository.findOne(id);
    }
}
