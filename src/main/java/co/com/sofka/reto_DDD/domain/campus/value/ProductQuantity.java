package co.com.sofka.reto_DDD.domain.campus.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ProductQuantity implements ValueObject<Integer> {

    private final Integer value;

    public ProductQuantity(Integer value) {
        this.value = Objects.requireNonNull(value);
        if (this.value < 1){
            throw new IllegalArgumentException("Tiene que haber una cantidad mayor a 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantity that = (ProductQuantity) o;
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
