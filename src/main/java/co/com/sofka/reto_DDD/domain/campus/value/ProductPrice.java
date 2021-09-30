package co.com.sofka.reto_DDD.domain.campus.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductPrice implements ValueObject<Integer> {

    private final Integer value;

    public ProductPrice(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.intValue() < 1){
            throw new IllegalArgumentException("El precio del producto no puede ser menor o igual a 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(value, that.value);
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
