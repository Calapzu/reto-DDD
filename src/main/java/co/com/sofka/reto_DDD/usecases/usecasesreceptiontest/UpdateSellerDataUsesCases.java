package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.UpdateSellerData;

public class UpdateSellerDataUsesCases extends UseCase<RequestCommand<UpdateSellerData>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateSellerData> updateSellerDataRequestCommand) {
        var command = updateSellerDataRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), retrieveEvents(command.getReceptionId().value()));
        reception.updateSellerData(command.getEntityId(), command.getAddres(), command.getEmailAddres(), command.getCellPhoneNumber(), command.getName());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
