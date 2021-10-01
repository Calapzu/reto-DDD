package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PetWeight implements ValueObject<Float> {

    private final Float value;

    public PetWeight(Float value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 1){
            throw new IllegalArgumentException("La mascota debe tener un peso mayo a 0");
        }
        if(this.value >= 50){
            throw new IllegalArgumentException("La mascota debe tener un peso menor a 50");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetWeight petWeight = (PetWeight) o;
        return Objects.equals(value, petWeight.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Float value() {
        return value;
    }
}
