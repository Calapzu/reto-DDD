package co.com.sofka.reto_DDD.domain.campus.value;

import co.com.sofka.domain.generic.Identity;

public class VeterinaryDoctorId extends Identity {

    public VeterinaryDoctorId() {
    }

    private VeterinaryDoctorId(String id) {
        super(id);
    }

    public static VeterinaryDoctorId of(String id){
        return new VeterinaryDoctorId(id);
    }
}
