package com.example.api.validators.lineValidators;

import com.example.api.validators.BaseLineValidator;
import com.example.api.validators.ValidationLineContext;
import com.example.api.validators.ValidationResult;

public class EdadValidator extends BaseLineValidator {
    @Override
    protected void doValidate(String[] line, ValidationLineContext context, ValidationResult result) {
        String edad = line[1];

        try {
            int edadInt = Integer.parseInt(edad.trim());

            if (edadInt < 0 || edadInt > 150) {
                context.addError("La edad debe estar entre 0 y 150");
                return;
            }

            context.withEdad(edadInt);
        } catch (NumberFormatException e) {
            context.addError("La edad debe ser un número válido");
        }
    }
}
