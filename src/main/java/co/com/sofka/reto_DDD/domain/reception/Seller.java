package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.genericvalue.*;
import co.com.sofka.reto_DDD.domain.reception.value.SellerId;

public class Seller extends Entity<SellerId> {
    private Addres addres;
    private EmailAddres emailAddres;
    private CellPhoneNumber cellPhoneNumber;
    private Name name;

    public Seller(SellerId entityId) {
        super(entityId);
    }
}
