package co.com.sofka.reto_DDD.domain.campus.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.Description;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;

public class UpdateDescrption extends Command {

    private final CampusId campusId;
    private final ServiceId serviceId;
    private final Description description;

    public UpdateDescrption(CampusId campusId, ServiceId serviceId, Description description) {
        this.campusId = campusId;
        this.serviceId = serviceId;
        this.description = description;
    }

    public CampusId getCampusId() {
        return campusId;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Description getDescription() {
        return description;
    }
}
