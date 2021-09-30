package co.com.sofka.reto_DDD.domain.reception.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class ReceptionCreated extends DomainEvent {

    private final Name name;

    public ReceptionCreated(Name name) {
        super("sofka.reception.receptioncreated");
        this.name = name;

    }

    public Name getName() {
        return name;
    }


}
