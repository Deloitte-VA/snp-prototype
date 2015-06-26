package com.github.jlgrock.snp.web.controllers;

import java.util.ArrayList;
import java.util.Set;

import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.web.resources.query.QueryParamBean;
import com.github.jlgrock.snp.web.resources.query.QueryParamHandler;
import com.github.jlgrock.snp.web.resources.query.QueryParamParser;
import com.github.jlgrock.snp.web.resources.response.ResponseStatusCode;
import com.github.jlgrock.snp.web.resources.response.SuccessResponse;
import com.github.jlgrock.snp.web.services.ClassifierQueryServiceImpl;

/**
 * The Controller serving up domain objects for Patient objectsØ.
 */
@Path("/patient")
public class PatientController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

    private PatientRepository patientRepository;
    private ClassifierQueryServiceImpl classifierQueryService;

    /**
     * @param repositoryIn the repository to get patients from
     */
    @Inject
    public PatientController(@Named("patientRepository") final PatientRepository repositoryIn,
    		final ClassifierQueryServiceImpl classifierQueryServiceIn) {
        patientRepository = repositoryIn;
        classifierQueryService = classifierQueryServiceIn;
    }

    /** 
     * @param id used to find encounter
     * @return single encounter that corresponds to id
     */
    @GET @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam("id") final Long id) {
        LOGGER.debug("getting Patient");
        return patientRepository.findOneById(id);
    }
    
    /**
     * 
     * @return
     */
    @GET @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSearch(@BeanParam QueryParamBean beanParam) {
    	LOGGER.debug("searching Patient");
    	LOGGER.debug("Bean param: " + beanParam);
    	
    	QueryParamParser queryHandler = new QueryParamParser();
    	queryHandler.handleRequest(beanParam);
    	
    	String obs = queryHandler.getFilter().get("observation");
    	Integer nid = Integer.parseInt(obs);
    	
    	Set<Patient> patients = classifierQueryService.findPatientsByNids(new ArrayList<Integer>(){{add(nid);}});
    	
    	SuccessResponse response = new SuccessResponse(ResponseStatusCode.OK, patients);
    	return Response.ok().entity(response).build();
    }
}

