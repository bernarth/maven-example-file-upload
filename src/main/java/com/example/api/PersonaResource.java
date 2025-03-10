package com.example.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@Path("/personas")
public class PersonaResource {
    @Inject
    PersonaService personaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> listAll() {
        return personaService.getAllPersonas();
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response uploadCSV(TxtUploadInput input) {
        try {
            System.out.println("Month: " + input.month);
            return personaService.validateCsvFile(input.file);
        } catch (Exception e) {
            return Response.serverError()
                .entity(Map.of("error", "Failed to process file: " + e.getMessage()))
                .build();
        }
    }

    public static class TxtUploadInput {
        @FormParam("file")
        public FileUpload file;

        @FormParam("month")
        public String month;
    }
}