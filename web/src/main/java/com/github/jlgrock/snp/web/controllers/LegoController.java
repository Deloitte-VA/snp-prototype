package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.apis.connection.configuration.WebConfiguration;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.InputStream;

/**
 *
 */
@Path("/lego")
public class LegoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LegoController.class);

    private MultiPartFileUtils multipartFileUtils;

    private WebConfiguration webConfiguration;

    @Inject
    public LegoController(final WebConfiguration webConfigurationIn, final MultiPartFileUtils multipartFileUtilsIn) {
        webConfiguration = webConfigurationIn;
        multipartFileUtils = multipartFileUtilsIn;
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition formDataContentDisposition) {
        LOGGER.debug("fileInputStream provided?=[{}], formDataContentDisposition provided?=[{}]", (fileInputStream != null), (formDataContentDisposition != null));
        LOGGER.debug("fileInputStream={}, fileName={}", fileInputStream, formDataContentDisposition.getFileName());

        java.nio.file.Path uploadedFileLocation = webConfiguration.fileLocation().resolve(formDataContentDisposition.getFileName());

        // save it
        multipartFileUtils.writeToFile(fileInputStream, uploadedFileLocation);

        LOGGER.debug("File uploaded to : " + uploadedFileLocation);

        //TODO this is where we add the connection to the XML parser

        return Response.ok().build();
    }
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/xml" media type.
     *
     * @return String that will be returned as a application/xml response.
     */
    @POST @Path("/pce")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public String getLego(String xml) {
    	return xml;
    }

}
