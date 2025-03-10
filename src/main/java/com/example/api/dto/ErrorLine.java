package com.example.api.dto;

import java.util.ArrayList;
import java.util.List;
import com.example.api.constants.FileConfig;

public class ErrorLine {
    private final List<String> errors;
    private final String originalLine;

    public ErrorLine(String originalLine) {
        errors = new ArrayList<>();
        this.originalLine = originalLine;
    }

    public ErrorLine(String originalLine, List<String> initialErrors) {
        errors = initialErrors;
        this.originalLine = originalLine;
    }

    public void addError(String error) {
        errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String toCsvLine() {
        String errorSeparator = ";";
        String errorMessage = String.join(errorSeparator, errors);

        return originalLine + FileConfig.SEPARATOR + "\"" + errorMessage + "\"";
    }
}