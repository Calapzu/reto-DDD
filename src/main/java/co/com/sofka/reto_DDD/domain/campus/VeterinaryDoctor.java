package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.VeterinaryDoctorId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class VeterinaryDoctor extends Entity<VeterinaryDoctorId> {

    private Name name;
    private EmailAddres emailAddres;
    private Addres addres;
    private CellPhoneNumber cellPhoneNumber;

    public VeterinaryDoctor(VeterinaryDoctorId entityId) {
        super(entityId);
    }
}
