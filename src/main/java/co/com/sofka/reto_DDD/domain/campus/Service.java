package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;

public class Service extends Entity<ServiceId> {

    public Service(ServiceId entityId) {
        super(entityId);
    }
}
