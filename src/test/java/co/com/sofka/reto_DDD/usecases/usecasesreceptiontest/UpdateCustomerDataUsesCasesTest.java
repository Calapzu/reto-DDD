package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.UpdateCustomerData;
import co.com.sofka.reto_DDD.domain.reception.event.CustomerAdded;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.event.UpdatedCustomerData;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

class UpdateCustomerDataUsesCasesTest {

    private UpdateCustomerDataUsesCases updateCustomerDataUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        updateCustomerDataUsesCases = new UpdateCustomerDataUsesCases();
        repository = mock(DomainEventRepository.class);
        updateCustomerDataUsesCases.addRepository(repository);
    }

    @Test
    public void updateCustomerDataUsesCases(){
        //Arrange
        var command = new UpdateCustomerData(
                ReceptionId.of("123456789"),
                new CustomerId("123"),
                new Name("Jhoan"),
                new AmountMoney(500f)
        );
        var useCase = new UpdateCustomerDataUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventUpdateCustomerData = (UpdatedCustomerData) events.get(0);
        Assertions.assertEquals("123", eventUpdateCustomerData.getCustomerId().value());
        Assertions.assertEquals("Jhoan", eventUpdateCustomerData.getName().value());
        Assertions.assertEquals(500f, eventUpdateCustomerData.getAmountMoney().value());
    }

    private List<DomainEvent> events(){
        return List.of(
                new ReceptionCreated(
                        new Name("Veterinaria La Finca")
                ),
                new CustomerAdded(
                        CustomerId.of("123"),
                        new Name("andres"),
                        new AmountMoney(600f)
                )
        );
    }

}