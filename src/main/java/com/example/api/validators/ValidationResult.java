package com.example.api.validators;

import com.example.api.Persona;
import com.example.api.dto.ErrorLine;
import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private int numberOfValidLines = 0;
    private final List<ErrorLine> errorLines = new ArrayList<>();
    private final List<Persona> validPersonas = new ArrayList<>();

    public void addErrorLine(ErrorLine errorLine) {
        errorLines.add(errorLine);
    }

    public void addValidPersona(Persona persona) {
        numberOfValidLines++;
        validPersonas.add(persona);
    }

    public boolean hasErrors() {
        return errorLines.size() > 1;
    }

    public List<ErrorLine> getErrorLines() {
        return errorLines;
    }

    public List<Persona> getValidPersonas() {
        return validPersonas;
    }

    public int getNumberOfValidLines() {
        return numberOfValidLines;
    }
}