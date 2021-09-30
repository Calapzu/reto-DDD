package co.com.sofka.reto_DDD.domain.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Addres implements ValueObject<String> {

    private final String value;

    public Addres(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La direccion no puede estar vacio");
        }
        if (this.value.length() <= 4){
            throw new IllegalArgumentException("Debes de tener una direccion mayor a 4 caracteres");
        }
        if (this.value.length() >= 100){
            throw new IllegalArgumentException("Debes de tener una direccion menor a 100 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
