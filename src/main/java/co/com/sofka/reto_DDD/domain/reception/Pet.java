package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.*;

public class Pet extends Entity<PetId> {

    private Name name;
    private PetBreed petBreed;
    private PetAge petAge;
    private PetWeight petWeight;
    private Diagnosis diagnosis;

    public Pet(PetId entityId) {
        super(entityId);
    }
}
