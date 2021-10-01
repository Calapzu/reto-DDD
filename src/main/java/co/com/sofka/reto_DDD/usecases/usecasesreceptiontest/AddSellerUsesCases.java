package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.AddSeller;

public class AddSellerUsesCases extends UseCase<RequestCommand<AddSeller>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddSeller> addSellerRequestCommand) {
        var command = addSellerRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), retrieveEvents(command.getReceptionId().value()));
        reception.addSeller(command.getEntityId(), command.getAddres(), command.getEmailAddres(), command.getCellPhoneNumber(), command.getName());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
