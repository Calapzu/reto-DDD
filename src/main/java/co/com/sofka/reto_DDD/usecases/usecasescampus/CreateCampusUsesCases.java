package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.campus.Campus;
import co.com.sofka.reto_DDD.domain.campus.command.CreateCampus;

public class CreateCampusUsesCases extends UseCase<RequestCommand<CreateCampus>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCampus> createCampusRequestCommand) {
        var command = createCampusRequestCommand.getCommand();
        var campus = new Campus(command.getCampusId(), command.getName(), command.getCellPhoneNumber(), command.getAddres());
        emit().onResponse(new ResponseEvents(campus.getUncommittedChanges()));
    }
}
