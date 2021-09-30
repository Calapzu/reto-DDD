package co.com.sofka.reto_DDD.domain.campus.value;

import co.com.sofka.domain.generic.Identity;

public class ServiceId extends Identity {

    public ServiceId() {
    }

    private ServiceId(String id) {
        super(id);
    }

    public static ServiceId of(String id){
        return new ServiceId(id);
    }
}
