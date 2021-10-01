package co.com.sofka.reto_DDD.domain.reception.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.reception.value.Diagnosis;
import co.com.sofka.reto_DDD.domain.reception.value.PetId;

public class ModifiedDiagnosis extends DomainEvent {

    private final PetId petId;
    private final Diagnosis diagnosis;

    public ModifiedDiagnosis(PetId petId, Diagnosis diagnosis) {
        super("sofka.reception.updatedsellerdata");
        this.petId = petId;
        this.diagnosis = diagnosis;
    }



    public PetId getPetId() {
        return petId;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
