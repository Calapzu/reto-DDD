package co.com.sofka.reto_DDD.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.AddSeller;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.event.SellerAdded;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import co.com.sofka.reto_DDD.domain.reception.value.SellerId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AddSellerUsesCasesTest {

    private AddSellerUsesCases addSellerUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        addSellerUsesCases = new AddSellerUsesCases();
        repository = mock(DomainEventRepository.class);
        addSellerUsesCases.addRepository(repository);
    }

    @Test
    public void createSeller(){
        //Arrannge
        var command = new AddSeller(
                ReceptionId.of("123456789"),
                new SellerId("123"),
                new Addres("Barrio 7 de agosto"),
                new EmailAddres("carlos@gmail.com"),
                new CellPhoneNumber("3107255406"),
                new Name("Carlos")
        );
        var useCase = new AddSellerUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var evenSellerAdded = (SellerAdded) events.get(0);
        Assertions.assertEquals("123", evenSellerAdded.getEntityId().value());
        Assertions.assertEquals("Carlos", evenSellerAdded.getName().value());
        Assertions.assertEquals("3107255406", evenSellerAdded.getCellPhoneNumber().value());
        Assertions.assertEquals("carlos@gmail.com", evenSellerAdded.getEmailAddres().value());
        Assertions.assertEquals("Barrio 7 de agosto", evenSellerAdded.getAddres().value());

    }

    private List<DomainEvent> events(){
        return List.of(new ReceptionCreated(
                new Name("Veterinaria La Finca")
        ));
    }

}