package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto_DDD.domain.campus.command.CreateCampus;
import co.com.sofka.reto_DDD.domain.campus.event.CampusCreated;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateCampusUsesCasesTest {
    @Test
    public void createCampusUsesCasesTest(){
        //Arrnange
        var command = new CreateCampus(
                CampusId.of("123456789"),
                new Name("Sede principal"),
                new CellPhoneNumber("3107255406"),
                new Addres("Centro")
        );
        var useCase = new CreateCampusUsesCases();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (CampusCreated) events.get(0);
        Assertions.assertEquals("Sede principal", event.getName().value());
        Assertions.assertEquals("3107255406", event.getCellPhoneNumber().value());
        Assertions.assertEquals("Centro", event.getAddres().value());
    }

}