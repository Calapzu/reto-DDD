package co.com.sofka.reto_DDD.domain.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

public class Addres implements ValueObject<String> {

    private final String value;

    public Addres(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
