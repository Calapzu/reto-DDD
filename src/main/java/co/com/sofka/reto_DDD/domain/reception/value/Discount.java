package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Discount implements ValueObject<Long> {

    private final Long value;

    public Discount(Long value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 1){
            throw new IllegalArgumentException("El descuento no puede ser menor o igual a 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(value, discount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Long value() {
        return value;
    }
}
