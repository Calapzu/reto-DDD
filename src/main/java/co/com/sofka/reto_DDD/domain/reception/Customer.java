package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;
import co.com.sofka.reto_DDD.domain.reception.value.Discount;

public class Customer extends Entity<CustomerId> {

    private Name name;
    private AmountMoney amountMoney;
    private Discount discount;

    public Customer(CustomerId entityId) {
        super(entityId);
    }

}
