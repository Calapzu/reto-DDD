package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.command.AddProduct;
import co.com.sofka.reto_DDD.domain.campus.event.AddedProduct;
import co.com.sofka.reto_DDD.domain.campus.event.CampusCreated;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductPrice;
import co.com.sofka.reto_DDD.domain.campus.value.ProductQuantity;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.event.CustomerAdded;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AddProductUsesCasesTest {

    private AddProductUsesCases addProductUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        addProductUsesCases = new AddProductUsesCases();
        repository = mock(DomainEventRepository.class);
        addProductUsesCases.addRepository(repository);
    }

    @Test
    public void createProduct(){
        //Arrange
        var command = new AddProduct(
                CampusId.of("123456789"),
                new ProductId("123"),
                new Name("Lepesi"),
                new ProductPrice(10000),
                new ProductQuantity(2)
        );
        var useCase = new AddProductUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var evenProductoAdded = (AddedProduct) events.get(0);
        Assertions.assertEquals("123", evenProductoAdded.getProductId().value());
        Assertions.assertEquals("Lepesi", evenProductoAdded.getName().value());
        Assertions.assertEquals(10000, evenProductoAdded.getProductPrice().value());
        Assertions.assertEquals(2, evenProductoAdded.getProductQuantity().value());
    }

    private List<DomainEvent> events(){
        return List.of(new CampusCreated(
                new Name("Centro"),
                new CellPhoneNumber("3107255406"),
                new Addres("Centro")
        ));
    }

}