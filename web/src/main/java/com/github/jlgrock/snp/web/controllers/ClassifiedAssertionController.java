package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The Controller serving up domain objects for Assertion objects.
 */
@Path("/assertion")
public class ClassifiedAssertionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClassifiedAssertionController.class);


    private ClassifiedPceRepository repository;

    /**
     * @param repositoryIn the repository to get Assertion objects from
     */
    @Inject
    public ClassifiedAssertionController(final ClassifiedPceRepository repositoryIn) {
        repository = repositoryIn;
    }

    /**
     * Returns the Assertion for the respective <code>id</code>.
     *
     * @param nid the native identifier of the Assertion to get
     * @return Returns a Assertion
     */
    @GET @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ClassifiedPce getAssertion(@PathParam("id") final Integer nid) {
        LOGGER.debug("getting Assertion for id: {}", nid);
        return repository.findOneById(nid);
    }
}
