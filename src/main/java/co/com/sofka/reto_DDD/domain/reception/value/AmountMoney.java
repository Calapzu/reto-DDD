package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AmountMoney implements ValueObject<Float> {

    private final Float value;

    public AmountMoney(Float value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.floatValue()<= 1){
            throw new IllegalArgumentException("No puedes tener dinero negativo o igual a cero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountMoney that = (AmountMoney) o;
        return Objects.equals(value, that.value);
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
