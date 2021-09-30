package co.com.sofka.reto_DDD.domain.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

public class CellPhoneNumber implements ValueObject<Long> {

    private final Long value;

    public CellPhoneNumber(Long value) {
        this.value = value;
    }

    @Override
    public Long value() {
        return value;
    }
}
