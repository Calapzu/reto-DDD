package co.com.sofka.reto_DDD.domain.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CellPhoneNumber implements ValueObject<String> {

    private final String value;

    public CellPhoneNumber(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El numero de celular no puede estar vacio");
        }
        if (this.value.length() != 10){
            throw new IllegalArgumentException("El numero debe tener 10 digitos");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellPhoneNumber that = (CellPhoneNumber) o;
        return Objects.equals(value, that.value);
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
