package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PetBreed implements ValueObject<String> {

    private final String value;

    public PetBreed(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacia");
        }
        if (this.value.length() <= 5){
            throw new IllegalArgumentException("Debes de tener mayor a 5 caracteres");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetBreed petBreed = (PetBreed) o;
        return Objects.equals(value, petBreed.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
