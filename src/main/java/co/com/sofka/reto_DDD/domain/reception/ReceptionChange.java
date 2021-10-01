package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto_DDD.domain.reception.event.*;

import java.util.HashSet;

public class ReceptionChange extends EventChange {

    public ReceptionChange(Reception reception) {
        apply((ReceptionCreated event) -> {
            reception.name = event.getName();
            reception.pets = new HashSet<>();
            reception.customers = new HashSet<>();
            reception.sellers = new HashSet<>();
        });

        apply((CustomerAdded event) -> {
            reception.customers.add(
                    new Customer(event.getCustomerId(),
                            event.getName(),
                            event.getAmountMoney()));
        });

        apply((UpdatedCustomerData event) -> {
            var customer = reception.getCustomerForId(event.getCustomerId())
                    .orElseThrow(()-> new IllegalArgumentException("No existe un cliente con ID "+event.getCustomerId()));
            customer.updateCustomerData(event.getCustomerId(), event.getName(), event.getAmountMoney());
        });

        apply((SellerAdded event) -> {
            reception.sellers.add(new Seller(event.getEntityId(), event.getAddres(), event.getEmailAddres(), event.getCellPhoneNumber(), event.getName()));
        });

        apply((UpdatedSellerData event) -> {
            var seller = reception.getSellerForId(event.getEntityId())
                    .orElseThrow(()-> new IllegalArgumentException("No existe un vendedor con ID "+event.getEntityId()));
            seller.updateSellerData(event.getAddres(), event.getEmailAddres(), event.getCellPhoneNumber(), event.getName());
        });

        apply((PetAdded event) -> {
            reception.pets.add(new Pet(event.getEntityId(), event.getName(), event.getPetBreed(), event.getPetAge(), event.getPetWeight(), event.getDiagnosis()));
        });

        apply((ModifiedPetData event) -> {
            var pet = reception.gePetForId(event.getPetId())
                    .orElseThrow(()->new IllegalArgumentException("No existe la mnascota con el ID "+event.getPetId()));
            pet.modifyPetData(event.getName(), event.getPetBreed(), event.getPetAge(), event.getPetWeight());
        });

        apply((ModifiedDiagnosis event) -> {
            var pet = reception.gePetForId(event.getPetId())
                    .orElseThrow(()->new IllegalArgumentException("No existe la mascota con el ID "+event.getPetId()));
            pet.modifyDiagnosis( event.getDiagnosis());
        });




    }
}
