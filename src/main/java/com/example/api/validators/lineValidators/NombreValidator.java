package com.example.api.validators.lineValidators;

import com.example.api.validators.BaseLineValidator;
import com.example.api.validators.ValidationLineContext;
import com.example.api.validators.ValidationResult;

public class NombreValidator extends BaseLineValidator {
    @Override
    protected void doValidate(String[] line, ValidationLineContext context, ValidationResult result) {
        String nombre = line[0];

        if (nombre == null || nombre.trim().isEmpty()) {
            context.addError("El nombre no puede ser nulo o vacío");
            return;
        }

        if (!nombre.matches("[a-zA-ZÀ-ÿ0-9\\s]+")) {
            context.addError("El nombre contiene caracteres no permitidos");
            return;
        }

        context.withNombre(nombre);
    }
}
