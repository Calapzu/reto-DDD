package co.com.sofka.reto_DDD.domain.campus.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.value.VeterinaryDoctorId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class AddedVeterinaryDoctor extends DomainEvent {

    private final VeterinaryDoctorId veterinaryDoctorId;
    private final Name name;
    private final Addres addres;
    private final EmailAddres emailAddres;
    private final CellPhoneNumber cellPhoneNumber;

    public AddedVeterinaryDoctor(VeterinaryDoctorId veterinaryDoctorId, Name name, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber) {
        super("sofka.campus.AddedVeterinaryDoctor");
        this.veterinaryDoctorId = veterinaryDoctorId;
        this.name = name;
        this.addres = addres;
        this.emailAddres = emailAddres;
        this.cellPhoneNumber = cellPhoneNumber;
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
