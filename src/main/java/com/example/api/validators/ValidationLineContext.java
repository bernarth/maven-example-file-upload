package com.example.api.validators;

import com.example.api.Persona;
import com.example.api.dto.ErrorLine;

import java.time.LocalDate;

public class ValidationLineContext {
    private final Persona persona = new Persona();
    private final ErrorLine errorLine;

    public ValidationLineContext(String originalLine) {
        errorLine = new ErrorLine(originalLine);
    }
    
    public boolean hasErrors() {
        return errorLine.hasErrors();
    }

    public ErrorLine getErrorLine() {
        return errorLine;
    }

    public void addError(String error) {
        errorLine.addError(error);
    }

    public Persona getPersona() {
        return persona;
    }

    public void withId(Long id) {
        persona.setId(id);
    }

    public void withNombre(String nombre)  {
        persona.setNombre(nombre);
    }

    public void withEdad(int edad)  {
        persona.setEdad(edad);
    }

    public void withFechaNacimiento(LocalDate fechaNacimiento)  {
        persona.setFechaNacimiento(fechaNacimiento);
    }
}
