package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;

public class Customer extends Entity<CustomerId> {

    public Customer(CustomerId entityId) {
        super(entityId);
    }
}
