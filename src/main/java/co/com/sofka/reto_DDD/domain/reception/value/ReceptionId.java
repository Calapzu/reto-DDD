package co.com.sofka.reto_DDD.domain.reception.value;

import co.com.sofka.domain.generic.Identity;

public class ReceptionId extends Identity {

    public ReceptionId() {
    }

    private ReceptionId(String id) {
        super(id);
    }

    public static ReceptionId of(String id){
        return new ReceptionId(id);
    }
}
