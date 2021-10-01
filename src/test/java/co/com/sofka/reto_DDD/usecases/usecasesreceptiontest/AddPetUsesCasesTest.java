package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.AddPet;
import co.com.sofka.reto_DDD.domain.reception.event.PetAdded;
import co.com.sofka.reto_DDD.domain.reception.event.ReceptionCreated;
import co.com.sofka.reto_DDD.domain.reception.value.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

class AddPetUsesCasesTest {

    private AddPetUsesCases addPetUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        addPetUsesCases = new AddPetUsesCases();
        repository = mock(DomainEventRepository.class);
        addPetUsesCases.addRepository(repository);
    }

    @Test
    public void createPet(){
        //Arrange
        var command = new AddPet(
                ReceptionId.of("123456789"),
                new PetId("123"),
                new Name("Zeus"),
                new PetBreed("Pitbull"),
                new PetAge(2),
                new PetWeight(10F),
                new Diagnosis("El perro presenta diarrea")
        );
        var useCase = new AddPetUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventPetAdded = (PetAdded) events.get(0);
        Assertions.assertEquals("123", eventPetAdded.getEntityId().value());
        Assertions.assertEquals("Zeus", eventPetAdded.getName().value());
        Assertions.assertEquals("Pitbull", eventPetAdded.getPetBreed().value());
        Assertions.assertEquals(2, eventPetAdded.getPetAge().value());
        Assertions.assertEquals(10F, eventPetAdded.getPetWeight().value());
        Assertions.assertEquals("El perro presenta diarrea", eventPetAdded.getDiagnosis().value());
    }

    private List<DomainEvent> events(){
        return List.of(new ReceptionCreated(
                new Name("Veterinaria La Finca")
        ));
    }

}