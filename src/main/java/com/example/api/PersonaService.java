package com.example.api;

import com.example.api.validators.FileValidator;
import com.example.api.validators.ValidationResult;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.Map;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@ApplicationScoped
public class PersonaService {
    public List<Persona> getAllPersonas() {
        return Persona.listAll();
    }

    public Response validateCsvFile(FileUpload file) throws IOException {
        FileValidator fileValidator = new FileValidator();
        File fileToValidate = file.uploadedFile().toFile();
        ValidationResult validationResult = fileValidator.validate(fileToValidate);

        if (validationResult.hasErrors()) {
            // GENERAR ARCHIVO CON ERRORES
            File errorFile = File.createTempFile("error_report", ".csv");

            try (PrintWriter writer = new PrintWriter(errorFile)) {
                validationResult.getErrorLines().forEach(
                errorLine -> writer.println(errorLine.toCsvLine()));
            }

            return Response
                .status(Response.Status.BAD_REQUEST)
                .header("Content-Disposition", "attachment; filename=error_report.csv")
                .header("Content-Type", "text/csv")
                .entity(errorFile)
                .build();
        }

        List<Persona> validPersonas = validationResult.getValidPersonas();
        savePersonas(validPersonas);

        return Response.ok(Map.of(
            "message", "Successfully imported " + validPersonas.size() + " records",
            "totalProcessed", validationResult.getNumberOfValidLines()
        )).build();
    }

    @Transactional
    public void savePersonas(List<Persona> personas) {
        for (Persona persona : personas) {
            persona.persist();
        }
    }
}