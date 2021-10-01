package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.campus.Campus;
import co.com.sofka.reto_DDD.domain.campus.command.UpdateVeterinaryDoctorData;

public class UpdateVeterinayDataUsesCases extends UseCase<RequestCommand<UpdateVeterinaryDoctorData>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateVeterinaryDoctorData> updateVeterinaryDoctorDataRequestCommand) {
        var command = updateVeterinaryDoctorDataRequestCommand.getCommand();
        var veterinary = Campus.from(command.getCampusId(), retrieveEvents(command.getCampusId().value()));
        veterinary.updateVeterinayDoctorData(command.getVeterinaryDoctorId(), command.getName(), command.getAddres(), command.getEmailAddres(), command.getCellPhoneNumber());
        emit().onResponse(new ResponseEvents(veterinary.getUncommittedChanges()));
    }
}
