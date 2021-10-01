package co.com.sofka.reto_DDD.usecasesreceptiontest;

import co.com.sofka.business.repository.DomainEventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
        
    }

}