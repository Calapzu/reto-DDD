package co.com.sofka.reto_DDD.domain.reception.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.*;

public class PetAdded extends DomainEvent {

    private final PetId entityId;
    private final Name name;
    private final PetBreed petBreed;
    private final PetAge petAge;
    private final PetWeight petWeight;
    private final Diagnosis diagnosis;

    public PetAdded(PetId entityId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight, Diagnosis diagnosis) {
        super("sofka.reception.petadded");
        this.entityId = entityId;
        this.name = name;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petWeight = petWeight;
        this.diagnosis = diagnosis;
    }

    public PetId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public PetBreed getPetBreed() {
        return petBreed;
    }

    public PetAge getPetAge() {
        return petAge;
    }

    public PetWeight getPetWeight() {
        return petWeight;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
