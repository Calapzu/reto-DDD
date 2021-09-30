package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diagnosis implements ValueObject<String> {

    private final String value;

    public Diagnosis(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El diagnostico no puede estar vacia");
        }
        if (this.value.length() <= 5){
            throw new IllegalArgumentException("Debes de tener mayor a 5 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
