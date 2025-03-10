package com.example.api.validators.lineValidators;

import com.example.api.constants.FileConfig;
import com.example.api.validators.BaseLineValidator;
import com.example.api.validators.ValidationLineContext;
import com.example.api.validators.ValidationResult;

public class LineValidator extends BaseLineValidator {
    @Override
    protected void doValidate(String[] line, ValidationLineContext context, ValidationResult result) {
        if (line == null || line.length != FileConfig.NUMBER_OF_COLUMNS) {
            context.addError("Número de columnas erroneo (revise el formato)");
        }
    }
}
