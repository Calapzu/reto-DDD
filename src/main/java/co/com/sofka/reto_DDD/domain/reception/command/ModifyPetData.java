package co.com.sofka.reto_DDD.domain.reception.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.*;

public class ModifyPetData extends Command {

    private final ReceptionId receptionId;
    private final PetId petId;
    private final Name name;
    private final PetBreed petBreed;
    private final PetAge petAge;
    private final PetWeight petWeight;

    public ModifyPetData(ReceptionId receptionId, PetId petId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight) {
        this.receptionId = receptionId;
        this.petId = petId;
        this.name = name;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petWeight = petWeight;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
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
