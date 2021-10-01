package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.ModifyPetData;

public class ModifyPetDataUsesCase extends UseCase<RequestCommand<ModifyPetData>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModifyPetData> modifyPetDataRequestCommand) {
        var command = modifyPetDataRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), retrieveEvents(command.getReceptionId().value()));
        reception.modifyPetData(command.getPetId(), command.getName(), command.getPetBreed(), command.getPetAge(), command.getPetWeight());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));
    }
}
