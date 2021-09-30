package co.com.sofka.reto_DDD.domain.reception.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;

public class CustomerAdded extends DomainEvent {

    private final CustomerId customerId;
    private final Name name;
    private final AmountMoney amountMoney;

    public CustomerAdded(CustomerId customerId, Name name, AmountMoney amountMoney) {
        super("sofka.reception.customeradded");
        this.customerId = customerId;
        this.name = name;
        this.amountMoney = amountMoney;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Name getName() {
        return name;
    }

    public AmountMoney getAmountMoney() {
        return amountMoney;
    }
}
