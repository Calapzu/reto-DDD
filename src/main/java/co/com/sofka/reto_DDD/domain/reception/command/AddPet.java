package co.com.sofka.reto_DDD.domain.reception.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.*;

public class AddPet extends Command {

    private final ReceptionId receptionId;
    private final PetId entityId;
    private final Name name;
    private final PetBreed petBreed;
    private final PetAge petAge;
    private final PetWeight petWeight;
    private final Diagnosis diagnosis;

    public AddPet(ReceptionId receptionId, PetId entityId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight, Diagnosis diagnosis) {
        this.receptionId = receptionId;
        this.entityId = entityId;
        this.name = name;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petWeight = petWeight;
        this.diagnosis = diagnosis;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
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
