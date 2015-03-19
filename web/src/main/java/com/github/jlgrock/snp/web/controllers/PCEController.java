package com.github.jlgrock.snp.web.controllers;

//import com.github.jlgrock.snp.core.data.PCERepository;
import com.github.jlgrock.snp.core.domain.PCE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
     * Returns the PCE for the respective <code>id</code>.
     *
     * @param id the id of the PCE to get
     * @return Returns a PCE
     */
    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PCE getPCE(@PathParam("id") final Long id) {
        LOGGER.debug("getting encounter");
        final PCE p = new PCE();
        p.setId(id);
        p.setDesc("bla");
        return p;
//        return "{\"pce\": \"example\", \"id\":" + id + "}";
//        return repository.findOne(id);
    }
}
