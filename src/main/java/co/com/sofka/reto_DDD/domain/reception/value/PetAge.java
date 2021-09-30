package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PetAge implements ValueObject<Integer> {

    private final Integer value;

    public PetAge(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.intValue() > 0){
            throw new IllegalArgumentException("La mascota no puede tener 0 o menos que 0");
        }
        if (this.value.intValue() <= 27){
            throw new IllegalArgumentException("La mascota no puede tener mas de 27 años");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetAge petAge = (PetAge) o;
        return Objects.equals(value, petAge.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
