package com.example.api.validators.lineValidators;

import com.example.api.Persona;
import com.example.api.validators.BaseLineValidator;
import com.example.api.validators.ValidationLineContext;
import com.example.api.validators.ValidationResult;

public class IdValidator extends BaseLineValidator {
    @Override
    protected void doValidate(String[] line, ValidationLineContext context, ValidationResult result) {
        long id = getId(result);
        context.withId(id);
    }

    private long getId(ValidationResult result) {
        int personasSize = result.getValidPersonas().size();

        if (result.getValidPersonas().isEmpty()) {
            return getLargestId() + 1;
        }

        Persona lastPersona = result.getValidPersonas().get(personasSize - 1);

        return lastPersona.getId() + 1;
    }

    public long getLargestId() {
        Persona personaWithLargestId = Persona.find("ORDER BY id DESC").firstResult();

        return personaWithLargestId != null ? personaWithLargestId.getId() : 0;
    }
}
