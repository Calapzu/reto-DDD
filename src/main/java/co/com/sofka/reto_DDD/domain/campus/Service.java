package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.Description;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;

import java.util.Objects;

public class Service extends Entity<ServiceId> {

    private Description description;

    public Service(ServiceId entityId, Description description) {
        super(entityId);
        this.description = description;
    }

    public void updateDescription(Description description){
        this.description = Objects.requireNonNull(description);
    }

    public Description description() {
        return description;
    }
}
