package co.com.sofka.reto_DDD.domain.campus.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class AssociatedReception extends DomainEvent {

    private final ReceptionId receptionId;

    public AssociatedReception(ReceptionId receptionId) {
        super("sofka.campus.associatedreception");
        this.receptionId = receptionId;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }
}
