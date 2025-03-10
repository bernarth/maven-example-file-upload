package com.example.api.validators;

import com.example.api.constants.FileConfig;
import com.example.api.dto.ErrorLine;
import com.example.api.validators.lineValidators.*;

import java.io.*;
import java.util.List;

public class FileValidator {
    private final ValidationResult validationResult = new ValidationResult();

    public ValidationResult validate(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                if (lineNumber == 1) {
                    ErrorLine errorLine = new ErrorLine(line, List.of("descripción_de_error"));
                    validationResult.addErrorLine(errorLine);
                    continue;
                }

                validateLine(line);
            }
        }

        return validationResult;
    }

    private void validateLine(String line) {
        String[] values = line.split(FileConfig.SEPARATOR);
        ValidationLineContext context = new ValidationLineContext(line);

        LineValidator lineValidator = new LineValidator();
        NombreValidator nombreValidator = new NombreValidator();
        EdadValidator edadValidator = new EdadValidator();
        FechaNacimientoValidator fechaNacimientoValidator = new FechaNacimientoValidator();
        IdValidator idValidator = new IdValidator();

        // Agregar validadores encadenarlos en orden
        fechaNacimientoValidator.setSiguiente(idValidator);
        edadValidator.setSiguiente(fechaNacimientoValidator);
        nombreValidator.setSiguiente(edadValidator);
        lineValidator.setSiguiente(nombreValidator);

        lineValidator.validate(values, context, validationResult);

        if (context.hasErrors()) {
            validationResult.addErrorLine(context.getErrorLine());
        }
        
        validationResult.addValidPersona(context.getPersona());
    }
}