package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;

public class Campus extends AggregateEvent<CampusId> {

    public Campus(CampusId entityId) {
        super(entityId);
    }
}
