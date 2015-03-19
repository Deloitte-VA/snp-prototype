package com.github.jlgrock.snp.web.controllers;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 *
 */
@Path("/lego")
public class LegoController extends JerseyTestNg.ContainerPerClassTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LegoController.class);

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

        return Response.status(200).entity(output).build();

    }

    /**
     * Save the uploaded file to new location
     */
    private void writeToFile(final InputStream uploadedInputStream,
                             final String uploadedFileLocation) {

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(Paths.get(uploadedFileLocation).toFile());
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @POST
    @Path("/")
    @Consumes(MediaType.TEXT_XML)
    public String consume(@FormDataParam("part") String s) {
        return s;
    }
}
