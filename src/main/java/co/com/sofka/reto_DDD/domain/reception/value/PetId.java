package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.Identity;

public class PetId extends Identity {

    public PetId() {
    }

    private PetId(String id) {
        super(id);
    }

    public static PetId of(String id){
        return new PetId(id);
    }

}
