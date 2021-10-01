package co.com.sofka.reto_DDD.domain.campus.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class UpdateCampusData extends Command {

    private final CampusId campusId;
    private final Name name;
    private final CellPhoneNumber cellPhoneNumber;
    private final Addres addres;

    public UpdateCampusData(CampusId campusId, Name name, CellPhoneNumber cellPhoneNumber, Addres addres) {
        this.campusId = campusId;
        this.name = name;
        this.cellPhoneNumber = cellPhoneNumber;
        this.addres = addres;
    }

    public CampusId getCampusId() {
        return campusId;
    }

    public Name getName() {
        return name;
    }

    public CellPhoneNumber getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public Addres getAddres() {
        return addres;
    }
}
