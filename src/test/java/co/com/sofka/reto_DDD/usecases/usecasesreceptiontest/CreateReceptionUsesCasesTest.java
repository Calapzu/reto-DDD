package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.CreateReception;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateReceptionUsesCasesTest {

    @Test
    public void createReceptionUsesCasesTest(){
        //Arrange
        var command = new CreateReception(
                ReceptionId.of("123456789"),
                new Name("Veterinaria La Finca")
        );
        var useCase = new CreateReceptionUsesCases();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ReceptionCreated) events.get(0);
        Assertions.assertEquals("Veterinaria La Finca", event.getName().value() );
    }

}