package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.Service;
import co.com.sofka.reto_DDD.domain.campus.command.AddService;
import co.com.sofka.reto_DDD.domain.campus.command.UpdateDescrption;
import co.com.sofka.reto_DDD.domain.campus.event.AddedService;
import co.com.sofka.reto_DDD.domain.campus.event.CampusCreated;
import co.com.sofka.reto_DDD.domain.campus.event.UpdatedDescription;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.Description;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.event.CustomerAdded;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UpdateDescriptionUsesCasesTest {

    private UpdateDescriptionUsesCases updateDescriptionUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        updateDescriptionUsesCases = new UpdateDescriptionUsesCases();
        repository = mock(DomainEventRepository.class);
        updateDescriptionUsesCases.addRepository(repository);
    }

    @Test
    void updateDescriptionUsesCases(){
        //Arrange
        var command = new UpdateDescrption(
                CampusId.of("123456789"),
                new ServiceId("123"),
                new Description("arrozs")
        );
        var useCase = new UpdateDescriptionUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asert
        var eventUpdatedDescription = (UpdatedDescription) events.get(0);
        Assertions.assertEquals("123", eventUpdatedDescription.getServiceId().value());
        Assertions.assertEquals("arrozs", eventUpdatedDescription.getDescription().value());


    }


    private List<DomainEvent> events(){
        return List.of(
                new CampusCreated(
                        new Name("Centro"),
                        new CellPhoneNumber("3107255406"),
                        new Addres("Jardin")
                ),
                new AddedService(
                        ServiceId.of("123"),
                        new Description("Mazorcas")
                )
        );
    }
}