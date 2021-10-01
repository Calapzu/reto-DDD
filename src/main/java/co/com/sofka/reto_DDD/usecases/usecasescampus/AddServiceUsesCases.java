package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.campus.Campus;
import co.com.sofka.reto_DDD.domain.campus.command.AddService;

public class AddServiceUsesCases extends UseCase<RequestCommand<AddService>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddService> addServiceRequestCommand) {
        var command = addServiceRequestCommand.getCommand();
        var service = Campus.from(command.getCampusId(), retrieveEvents(command.getCampusId().value()));
        service.addService(command.getServiceId(), command.getDescription());
        emit().onResponse(new ResponseEvents(service.getUncommittedChanges()));
    }
}
