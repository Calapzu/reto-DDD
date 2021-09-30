package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.reception.value.PetId;

public class Pet extends Entity<PetId> {

    public Pet(PetId entityId) {
        super(entityId);
    }
}
