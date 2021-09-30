package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.VeterinaryDoctorId;

public class VeterinaryDoctor extends Entity<VeterinaryDoctorId> {

    public VeterinaryDoctor(VeterinaryDoctorId entityId) {
        super(entityId);
    }
}
