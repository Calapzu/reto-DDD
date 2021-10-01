package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.AddCustomer;
import co.com.sofka.reto_DDD.domain.reception.event.CustomerAdded;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

class AddCustomerUsesCasesTest {

    private AddCustomerUsesCases addCustomerUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        addCustomerUsesCases = new AddCustomerUsesCases();
        repository = mock(DomainEventRepository.class);
        addCustomerUsesCases.addRepository(repository);
    }

    @Test
    public void createCustomer(){
        //Arrange
        var command = new AddCustomer(
                ReceptionId.of("123456789"),
                new CustomerId("123"),
                new Name("Jhoan"),
                new AmountMoney(10000.50F)
        );
        var useCase = new AddCustomerUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventCustomerAdded = (CustomerAdded) events.get(0);
        Assertions.assertEquals("Jhoan", eventCustomerAdded.getName().value());
        Assertions.assertEquals("123", eventCustomerAdded.getCustomerId().value());
        Assertions.assertEquals(10000.50F, eventCustomerAdded.getAmountMoney().value());

    }

    private List<DomainEvent> events(){
        return List.of(new ReceptionCreated(
                new Name("Veterinaria La Finca")
        ));
    }

}