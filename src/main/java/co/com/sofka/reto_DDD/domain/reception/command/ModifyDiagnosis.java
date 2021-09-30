package co.com.sofka.reto_DDD.domain.reception.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.reception.value.Diagnosis;
import co.com.sofka.reto_DDD.domain.reception.value.PetId;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class ModifyDiagnosis extends Command {

    private final ReceptionId receptionId;
    private final PetId petId;
    private final Diagnosis diagnosis;

    public ModifyDiagnosis(ReceptionId receptionId, PetId petId, Diagnosis diagnosis) {
        this.receptionId = receptionId;
        this.petId = petId;
        this.diagnosis = diagnosis;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public PetId getPetId() {
        return petId;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }
}
