package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.campus.Campus;
import co.com.sofka.reto_DDD.domain.campus.command.UpdateDescrption;

public class UpdateDescriptionUsesCases extends UseCase<RequestCommand<UpdateDescrption>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<UpdateDescrption> updateDescrptionRequestCommand) {
        var command  = updateDescrptionRequestCommand.getCommand();
        var description = Campus.from(command.getCampusId(), retrieveEvents(command.getCampusId().value()));
        description.updateDescription(command.getServiceId(), command.getDescription());
        emit().onResponse(new ResponseEvents(description.getUncommittedChanges()));
    }
}
