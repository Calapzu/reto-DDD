package co.com.sofka.reto_DDD.domain.reception.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.PetAge;
import co.com.sofka.reto_DDD.domain.reception.value.PetBreed;
import co.com.sofka.reto_DDD.domain.reception.value.PetId;
import co.com.sofka.reto_DDD.domain.reception.value.PetWeight;

public class ModifiedPetData extends DomainEvent{

    private final PetId petId;
    private final Name name;
    private final PetBreed petBreed;
    private final PetAge petAge;
    private final PetWeight petWeight;

    public ModifiedPetData(PetId petId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight) {
        super("sofka.reception.ModifiedPetData");
        this.petId = petId;
        this.name = name;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petWeight = petWeight;
    }

    public PetId getPetId() {
        return petId;
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
}
