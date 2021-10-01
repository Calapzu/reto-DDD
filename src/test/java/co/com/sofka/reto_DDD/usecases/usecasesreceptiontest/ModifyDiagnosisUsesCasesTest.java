package co.com.sofka.reto_DDD.usecases.usecasesreceptiontest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.command.ModifyDiagnosis;
import co.com.sofka.reto_DDD.domain.reception.event.ModifiedDiagnosis;
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

class ModifyDiagnosisUsesCasesTest {

    private ModifyDiagnosisUsesCases modifyDiagnosisUsesCases;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        modifyDiagnosisUsesCases = new ModifyDiagnosisUsesCases();
        repository = mock(DomainEventRepository.class);
        modifyDiagnosisUsesCases.addRepository(repository);
    }

    @Test
    public void modifyDiagnosis() {
        //Arrange
        var command = new ModifyDiagnosis(
                ReceptionId.of("123456789"),
                PetId.of("123"),
                new Diagnosis("Tiene fiebre")
        );
        var useCase = new ModifyDiagnosisUsesCases();
        Mockito.when(repository.getEventsBy("123456789")).thenReturn(events());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor("123456789")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();


        //assert
        var eventModifyDiagnosis = (ModifiedDiagnosis) events.get(0);
        Assertions.assertEquals("Tiene fiebre", eventModifyDiagnosis.getDiagnosis().value());

    }

    private List<DomainEvent> events() {
        return List.of(
                new ReceptionCreated(
                        new Name("Veterinaria La Finca")
                ),
                new PetAdded(
                        new PetId("123"),
                        new Name("Zeus"),
                        new PetBreed("Pitbull"),
                        new PetAge(2),
                        new PetWeight(5F),
                        new Diagnosis("Tiene diarrea")
                )
                );
    }


}