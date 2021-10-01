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

    public Pet(PetId entityId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight, Diagnosis diagnosis) {
        super(entityId);
        this.name = name;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petWeight = petWeight;
        this.diagnosis = diagnosis;
    }

    public void modifyPetData(Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight){
        this.name = name;
        this.petBreed = petBreed;
        this.petAge = petAge;
        this.petWeight = petWeight;
    }

    public void modifyDiagnosis(Diagnosis diagnosis){
        this.diagnosis = diagnosis;
    }

    public Name name() {
        return name;
    }

    public PetBreed petBreed() {
        return petBreed;
    }

    public PetAge petAge() {
        return petAge;
    }

    public PetWeight petWeight() {
        return petWeight;
    }

    public Diagnosis diagnosis() {
        return diagnosis;
    }
}
