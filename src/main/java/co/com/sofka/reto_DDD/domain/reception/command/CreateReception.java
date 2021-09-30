package co.com.sofka.reto_DDD.domain.reception.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class CreateReception extends Command {

    private final ReceptionId entityId;
    private final Name name;

    public CreateReception(ReceptionId entityId, Name name) {
        this.entityId = entityId;
        this.name = name;
    }

    public ReceptionId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
