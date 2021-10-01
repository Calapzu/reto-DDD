package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.VeterinaryDoctorId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

import java.util.Objects;

public class VeterinaryDoctor extends Entity<VeterinaryDoctorId> {

    private Name name;
    private EmailAddres emailAddres;
    private Addres addres;
    private CellPhoneNumber cellPhoneNumber;

    public VeterinaryDoctor(VeterinaryDoctorId entityId, Name name, EmailAddres emailAddres, Addres addres, CellPhoneNumber cellPhoneNumber) {
        super(entityId);
        this.name = name;
        this.emailAddres = emailAddres;
        this.addres = addres;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void UpdateVeterinaryDoctorData(Name name, EmailAddres emailAddres, Addres addres, CellPhoneNumber cellPhoneNumber){
        this.name = Objects.requireNonNull(name);
        this.emailAddres = Objects.requireNonNull(emailAddres);
        this.addres = Objects.requireNonNull(addres);
        this.cellPhoneNumber = Objects.requireNonNull(cellPhoneNumber);
    }

    public Name name() {
        return name;
    }

    public EmailAddres emailAddres() {
        return emailAddres;
    }

    public Addres addres() {
        return addres;
    }

    public CellPhoneNumber cellPhoneNumber() {
        return cellPhoneNumber;
    }
}
