package co.com.sofka.reto_DDD.domain.campus.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class AssociateReception extends Command {

    private  final CampusId campusId;
    private final ReceptionId receptionId;

    public AssociateReception(CampusId campusId, ReceptionId receptionId) {
        this.campusId = campusId;
        this.receptionId = receptionId;
    }

    public CampusId getCampusId() {
        return campusId;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }
}
