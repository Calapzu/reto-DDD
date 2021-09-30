package co.com.sofka.reto_DDD.domain.genericvalue;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EmailAddres implements ValueObject<String> {

    private final String value;

    public EmailAddres(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("El email no puede estar vacio");
        }
        if (this.value.length() <= 4){
            throw new IllegalArgumentException("Debes de tener mayor a 4 caracteres");
        }
        if (!value.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            throw new IllegalArgumentException("El email no es valido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddres that = (EmailAddres) o;
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
