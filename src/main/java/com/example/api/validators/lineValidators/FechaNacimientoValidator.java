package com.example.api.validators.lineValidators;

import com.example.api.validators.BaseLineValidator;
import com.example.api.validators.ValidationLineContext;
import com.example.api.validators.ValidationResult;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FechaNacimientoValidator extends BaseLineValidator {
    @Override
    protected void doValidate(String[] line, ValidationLineContext context, ValidationResult result) {
        String fechaNacimiento = line[2];
        try {
            LocalDate parsedDate = LocalDate.parse(fechaNacimiento);
            if (parsedDate.isAfter(LocalDate.now())) {
                context.addError("La fecha de nacimiento no puede ser una fecha futura");
            } else {
                context.withFechaNacimiento(parsedDate);
            }
        } catch (DateTimeParseException e) {
            context.addError("El formato de la fecha de nacimiento es inválido. Usa YYYY-MM-DD");
        }
    }
}
