package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.CreateReception;

public class CreateReceptionUsesCases extends UseCase<RequestCommand<CreateReception>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateReception> createReceptionRequestCommand) {
        var command = createReceptionRequestCommand.getCommand();
        var reception = new Reception(command.getEntityId(), command.getName());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
