package co.com.sofka.reto_DDD.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.AddCustomer;

public class AddCustomerUsesCases extends UseCase<RequestCommand<AddCustomer>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddCustomer> addCustomerRequestCommand) {
        var command = addCustomerRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), retrieveEvents(command.getEntityId().value()));
        reception.addCustomer(command.getEntityId(), command.getName(), command.getAmountMoney());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
