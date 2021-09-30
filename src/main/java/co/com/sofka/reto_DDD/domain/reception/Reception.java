package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class Reception extends AggregateEvent<ReceptionId> {

    public Reception(ReceptionId entityId) {
        super(entityId);
    }
}
