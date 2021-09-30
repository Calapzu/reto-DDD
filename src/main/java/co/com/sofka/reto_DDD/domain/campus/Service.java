package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.Description;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;

public class Service extends Entity<ServiceId> {

    private Description description;

    public Service(ServiceId entityId) {
        super(entityId);
    }
}
