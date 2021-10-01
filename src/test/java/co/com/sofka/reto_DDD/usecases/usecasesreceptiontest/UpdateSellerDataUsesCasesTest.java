package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.UpdateSellerData;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.event.SellerAdded;
import co.com.sofka.reto_DDD.domain.reception.event.UpdatedSellerData;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import co.com.sofka.reto_DDD.domain.reception.value.SellerId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

class UpdateSellerDataUsesCasesTest {

    private UpdateSellerDataUsesCases updateSellerDataUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        updateSellerDataUsesCases = new UpdateSellerDataUsesCases();
        repository = mock(DomainEventRepository.class);
        updateSellerDataUsesCases.addRepository(repository);
    }

    @Test
    public void updateSellerDataUsesCases(){
        //Arrange
        var command = new UpdateSellerData(
                ReceptionId.of("123456789"),
                new SellerId("123"),
                new Addres("Jardin"),
                new EmailAddres("jose@gmail.com"),
                new CellPhoneNumber("3145698796"),
                new Name("Copoazu")
        );
        var useCase = new UpdateSellerDataUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventUpdateSellerData = (UpdatedSellerData) events.get(0);
        Assertions.assertEquals("123", eventUpdateSellerData.getEntityId().value());
        Assertions.assertEquals("Copoazu", eventUpdateSellerData.getName().value());
        Assertions.assertEquals("3145698796", eventUpdateSellerData.getCellPhoneNumber().value());
        Assertions.assertEquals("Jardin", eventUpdateSellerData.getAddres().value());
        Assertions.assertEquals("jose@gmail.com", eventUpdateSellerData.getEmailAddres().value());
    }

    private List<DomainEvent> events(){
        return List.of(
                new ReceptionCreated(
                        new Name("Veterinaria La Finca")
                ),
                new SellerAdded(
                        SellerId.of("123"),
                        new Addres("7 de agosto"),
                        new EmailAddres("yamson@gmail.com"),
                        new CellPhoneNumber("3107255406"),
                        new Name("Yamson")
                )
        );
    }

}