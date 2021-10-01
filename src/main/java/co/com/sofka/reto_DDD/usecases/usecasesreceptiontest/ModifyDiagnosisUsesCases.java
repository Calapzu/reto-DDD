package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.reception.Reception;
import co.com.sofka.reto_DDD.domain.reception.command.ModifyDiagnosis;

public class ModifyDiagnosisUsesCases extends UseCase<RequestCommand<ModifyDiagnosis>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModifyDiagnosis> modifyDiagnosisRequestCommand) {
        var command = modifyDiagnosisRequestCommand.getCommand();
        var reception = Reception.from(command.getReceptionId(), retrieveEvents(command.getReceptionId().value()));
        reception.modifyDiagnosi(command.getPetId(), command.getDiagnosis());
        emit().onResponse(new ResponseEvents(reception.getUncommittedChanges()));

    }
}
