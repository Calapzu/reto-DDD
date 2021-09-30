package co.com.sofka.reto_DDD.domain.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

public class EmailAddres implements ValueObject<String> {

    private final String value;

    public EmailAddres(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
