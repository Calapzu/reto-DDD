package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.command.AddVeterinaryDoctor;
import co.com.sofka.reto_DDD.domain.campus.event.AddedVeterinaryDoctor;
import co.com.sofka.reto_DDD.domain.campus.event.CampusCreated;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.VeterinaryDoctorId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AddVeterinaryDoctorUsesCasesTest {

    private AddVeterinaryDoctorUsesCases addVeterinaryDoctorUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        addVeterinaryDoctorUsesCases = new AddVeterinaryDoctorUsesCases();
        repository = mock(DomainEventRepository.class);
        addVeterinaryDoctorUsesCases.addRepository(repository);
    }

    @Test
    void createVeterinaryDoctor(){
        //Arrange
        var command = new AddVeterinaryDoctor(
                CampusId.of("123456789"),
                new VeterinaryDoctorId("123"),
                new Name("Roberto"),
                new Addres("Ciudadela"),
                new EmailAddres("raberto@hotmail.com"),
                new CellPhoneNumber("3107255406")
        );
        var useCase = new AddVeterinaryDoctorUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventVeterinaryDoctorAdded = (AddedVeterinaryDoctor) events.get(0);

        Assertions.assertEquals("123", eventVeterinaryDoctorAdded.getVeterinaryDoctorId().value());
        Assertions.assertEquals("Roberto", eventVeterinaryDoctorAdded.getName().value());
        Assertions.assertEquals("Ciudadela", eventVeterinaryDoctorAdded.getAddres().value());
        Assertions.assertEquals("raberto@hotmail.com", eventVeterinaryDoctorAdded.getEmailAddres().value());
        Assertions.assertEquals("3107255406", eventVeterinaryDoctorAdded.getCellPhoneNumber().value());

    }

    private List<DomainEvent> events(){
        return List.of(new CampusCreated(
                new Name("Centro"),
                new CellPhoneNumber("3107255406"),
                new Addres("Centro")
        ));
    }
}