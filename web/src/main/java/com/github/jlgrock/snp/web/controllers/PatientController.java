package com.github.jlgrock.snp.web.controllers;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Patient;
import com.github.jlgrock.snp.web.resources.query.QueryParam;
import com.github.jlgrock.snp.web.resources.query.QueryParamParser;
import com.github.jlgrock.snp.web.resources.query.QueryUriBean;
import com.github.jlgrock.snp.web.resources.response.ResponseStatusCode;
import com.github.jlgrock.snp.web.resources.response.ResponseWrapper;
import com.github.jlgrock.snp.web.services.ClassifierQueryServiceImpl;

/**
 * The Controller serving up domain objects for Patient objectsØ.
 */
@Path("/patient")
public class PatientController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PatientController.class);

	private PatientRepository patientRepository;
	private ClassifierQueryServiceImpl classifierQueryService;

	/**
	 * @param repositoryIn
	 *            the repository to get patients from
	 * @param classifierQueryServiceIn
	 *            the classifier query service
	 */
	@Inject
	public PatientController(final PatientRepository repositoryIn,
			final ClassifierQueryServiceImpl classifierQueryServiceIn) {
		patientRepository = repositoryIn;
		classifierQueryService = classifierQueryServiceIn;
	}

	/**
	 * Gets patient for respective id
	 * 
	 * @param id
	 *            used to find patient
	 * @return single patient that corresponds to id
	 */
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Patient getPatient(@PathParam("id") final ObjectId id) {
		LOGGER.trace("getting Patient");
		return patientRepository.findOneById(id);
	}

	/**
	 * Executes searches for patients
	 * 
	 * @param beanUri
	 *            bean that is injected with URL parameters
	 * @return Response containing patients results for the given query
	 */
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearch(@BeanParam final QueryUriBean beanUri) {
		LOGGER.trace("searching Patient");
		LOGGER.debug("Bean URI: " + beanUri);

		QueryParamParser queryHandler = new QueryParamParser();
		QueryParam queryParam = queryHandler.handleRequest(beanUri);

		String obs = queryParam.getFilter().get("observation");
		if (obs == null) {
			String errMsg = "Missing 'observation' argument";
			LOGGER.error(errMsg);
			ResponseWrapper response = new ResponseWrapper(
					ResponseStatusCode.INVALID_REQUEST, null, errMsg);
			return Response.status(Status.BAD_REQUEST).entity(response).build();
		}

		Integer nid;
		try {
			nid = Integer.parseInt(obs);
		} catch (NumberFormatException e) {
			String errMsg = "Unable to parse 'observation' argument: " + obs;
			LOGGER.error(errMsg, e);
			ResponseWrapper response = new ResponseWrapper(
					ResponseStatusCode.INVALID_REQUEST, null, errMsg);
			return Response.status(Status.BAD_REQUEST).entity(response).build();
		}

		Set<Patient> patients = classifierQueryService.executeKindOfQuery(nid);

		ResponseWrapper response = new ResponseWrapper(ResponseStatusCode.OK,
				patients);
		return Response.ok().entity(response).build();
	}
}
