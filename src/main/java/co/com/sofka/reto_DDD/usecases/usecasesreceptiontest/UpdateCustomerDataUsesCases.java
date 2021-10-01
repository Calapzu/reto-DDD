package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.UpdateCustomerData;

public class UpdateCustomerDataUsesCases extends UseCase<RequestCommand<UpdateCustomerData>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCustomerData> updateCustomerDataRequestCommand) {
        var command = updateCustomerDataRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), retrieveEvents(command.getReceptionId().value()));
        reception.updateCustomerData(command.getCustomerId(), command.getName(), command.getAmountMoney());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
