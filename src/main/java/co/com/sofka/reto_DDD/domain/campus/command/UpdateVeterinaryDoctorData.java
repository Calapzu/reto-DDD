package co.com.sofka.reto_DDD.domain.campus.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.VeterinaryDoctorId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class UpdateVeterinaryDoctorData extends Command {

    private final CampusId campusId;
    private final VeterinaryDoctorId veterinaryDoctorId;
    private final Name name;
    private final Addres addres;
    private final EmailAddres emailAddres;
    private final CellPhoneNumber cellPhoneNumber;

    public UpdateVeterinaryDoctorData(CampusId campusId, VeterinaryDoctorId veterinaryDoctorId, Name name, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber) {
        this.campusId = campusId;
        this.veterinaryDoctorId = veterinaryDoctorId;
        this.name = name;
        this.addres = addres;
        this.emailAddres = emailAddres;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public CampusId getCampusId() {
        return campusId;
    }

    public VeterinaryDoctorId getVeterinaryDoctorId() {
        return veterinaryDoctorId;
    }

    public Name getName() {
        return name;
    }

    public Addres getAddres() {
        return addres;
    }

    public EmailAddres getEmailAddres() {
        return emailAddres;
    }

    public CellPhoneNumber getCellPhoneNumber() {
        return cellPhoneNumber;
    }
}
