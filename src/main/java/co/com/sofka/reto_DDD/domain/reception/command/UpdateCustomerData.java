package co.com.sofka.reto_DDD.domain.reception.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

public class UpdateCustomerData extends Command {

    private final ReceptionId receptionId;
    private final CustomerId customerId;
    private final Name name;
    private final AmountMoney amountMoney;

    public UpdateCustomerData(ReceptionId receptionId, CustomerId customerId, Name name, AmountMoney amountMoney) {
        this.receptionId = receptionId;
        this.customerId = customerId;
        this.name = name;
        this.amountMoney = amountMoney;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
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
