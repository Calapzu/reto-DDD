package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.campus.Campus;
import co.com.sofka.reto_DDD.domain.campus.command.AddVeterinaryDoctor;

public class AddVeterinaryDoctorUsesCases extends UseCase<RequestCommand<AddVeterinaryDoctor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddVeterinaryDoctor> addVeterinaryDoctorRequestCommand) {
        var command = addVeterinaryDoctorRequestCommand.getCommand();
        var veterinaryDoctor = Campus.from(command.getCampusId(), retrieveEvents(command.getCampusId().value()));
        veterinaryDoctor.addVeterinaryDoctor(command.getVeterinaryDoctorId(), command.getName(), command.getAddres(), command.getEmailAddres(), command.getCellPhoneNumber());
        emit().onResponse(new ResponseEvents((veterinaryDoctor.getUncommittedChanges())));
    }
}
