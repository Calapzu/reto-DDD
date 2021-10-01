package co.com.sofka.reto_DDD.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.AddCustomer;
import co.com.sofka.reto_DDD.domain.reception.command.AddPet;

public class AddPetUsesCases extends UseCase<RequestCommand<AddPet>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPet> addPetRequestCommand) {
        var command = addPetRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(),retrieveEvents(command.getReceptionId().value()));
        reception.addPet(command.getEntityId(), command.getName(), command.getPetBreed(), command.getPetAge(), command.getPetWeight(), command.getDiagnosis());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
