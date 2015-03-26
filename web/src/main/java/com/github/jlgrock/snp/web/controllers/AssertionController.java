package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.data.AssertionRepository;
import com.github.jlgrock.snp.core.domain.Assertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The Controller serving up domain objects for PCE objects.
 */
@Path("/assertion")
public class AssertionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssertionController.class);


    private AssertionRepository repository;

    /**
     * @param repositoryIn the repository to get PCEs from
     */
    @Inject
    public AssertionController(final AssertionRepository repositoryIn) {
        repository = repositoryIn;
    }

    /**
     * Returns the PCE for the respective <code>id</code>.
     *
     * @param id the id of the PCE to get
     * @return Returns a PCE
     */
    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Assertion getPce(@PathParam("id") final Long id) {
        LOGGER.debug("getting PCE");
        return repository.findOne(id);
    }
}
