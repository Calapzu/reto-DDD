package co.com.sofka.reto_DDD.domain.campus.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.value.Description;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;

public class UpdatedDescription extends DomainEvent {

    private final ServiceId serviceId;
    private final Description description;

    public UpdatedDescription(ServiceId serviceId, Description description) {
        super("sofka.campus.UpdatedDescription");
        this.serviceId = serviceId;
        this.description = description;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Description getDescription() {
        return description;
    }
}
