package co.com.sofka.reto_DDD.usecasesreceptiontest;

import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.AddCustomer;
import co.com.sofka.reto_DDD.domain.reception.command.CreateReception;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.value.AmountMoney;
import co.com.sofka.reto_DDD.domain.reception.value.CustomerId;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    public void createClient(){
        var command = new AddCustomer(
                ReceptionId.of("123456789"),
                new CustomerId("123"),
                new Name("Jhoan"),
                new AmountMoney(10000.50F)
        );
        when(repository.getEventsBy(any())).thenReturn(events());
    }

    private List<DomainEvent> events(){
        return List.of(new ReceptionCreated(
                new Name("Veterinnaria La Finca")
        ));
    }

}