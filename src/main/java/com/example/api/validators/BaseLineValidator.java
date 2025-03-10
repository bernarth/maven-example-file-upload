package com.example.api.validators;

public abstract class BaseLineValidator {
    protected BaseLineValidator siguiente = null;

    public BaseLineValidator setSiguiente(BaseLineValidator siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public void validate(String[] line, ValidationLineContext context, ValidationResult result) {
        doValidate(line, context, result);

        if (siguiente != null) {
            siguiente.validate(line, context, result);
        }
    }

    protected abstract void doValidate(String[] line, ValidationLineContext context, ValidationResult result);
}