package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.command.UpdateDescrption;
import co.com.sofka.reto_DDD.domain.campus.command.UpdateVeterinaryDoctorData;
import co.com.sofka.reto_DDD.domain.campus.event.*;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.Description;
import co.com.sofka.reto_DDD.domain.campus.value.ServiceId;
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

class UpdateVeterinayDataUsesCasesTest {
    private UpdateVeterinayDataUsesCases updateVeterinayDataUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup(){
        updateVeterinayDataUsesCases = new UpdateVeterinayDataUsesCases();
        repository = mock(DomainEventRepository.class);
        updateVeterinayDataUsesCases.addRepository(repository);
    }

    @Test
    void updateVeterinayDataUsesCases(){
        //Arrange
        var command = new UpdateVeterinaryDoctorData(
                CampusId.of("123456789"),
                VeterinaryDoctorId.of("123"),
                new Name("Copoazu"),
                new Addres("Jardin"),
                new EmailAddres("asdasda@fmail.com"),
                new CellPhoneNumber("3107255406")
        );
        var useCase = new UpdateVeterinayDataUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asert
        var eventVeterinaryDescription = (UpdatedVeterinaryDoctorData) events.get(0);
        Assertions.assertEquals("123", eventVeterinaryDescription.getVeterinaryDoctorId().value());
        Assertions.assertEquals("Copoazu", eventVeterinaryDescription.getName().value());
        Assertions.assertEquals("Jardin", eventVeterinaryDescription.getAddres().value());
        Assertions.assertEquals("asdasda@fmail.com", eventVeterinaryDescription.getEmailAddres().value());
        Assertions.assertEquals("3107255406", eventVeterinaryDescription.getCellPhoneNumber().value());


    }


    private List<DomainEvent> events(){
        return List.of(
                new CampusCreated(
                        new Name("Centro"),
                        new CellPhoneNumber("3107255406"),
                        new Addres("Jardin")
                ),
                new AddedVeterinaryDoctor(
                        new VeterinaryDoctorId("123"),
                        new Name("Calasdf"),
                        new Addres("Marozo"),
                        new EmailAddres("adsasdd@gmail.com"),
                        new CellPhoneNumber("3107255406")
                )
        );
    }
}