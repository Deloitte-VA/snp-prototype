package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.EncounterRepository;
import com.github.jlgrock.snp.core.domain.Encounter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The Controller serving up domain objects for Encounter objects.
 */

@Path("/encounter")
public class EncounterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncounterController.class);
   
    private final EncounterRepository repository;

    @Inject
    EncounterController(final EncounterRepository repositoryIn) {
        repository = repositoryIn;
    }

    /**
     * Returns the encounter for the respective <code>id</code>.
     * @param id encounter id used for search
     * @return returns an encounter
     */
    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Encounter getEncounter(@PathParam("id") final Long id) {
        LOGGER.debug("getting encounter");
        return repository.findOne(id);
    }
    
    
    /* Just for temporary testing of WAR file. Comment Autowired repository var. And used the method below.
     * But currently this method gives "Could not find acceptable representation" error. */
    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Encounter getEncounter(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return  new Encounter(); //repository.findOne(id);
    }
    */
    
    
    /* Returning String object works with the browser without any problem during testing */
    /*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getEncounter(@PathVariable final Long id) {
        LOGGER.debug("getting encounter");
        return  "Hello Encounter Service"; //repository.findOne(id);
    }
    */
}
