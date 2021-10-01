package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.event.*;
import co.com.sofka.reto_DDD.domain.reception.value.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Reception extends AggregateEvent<ReceptionId> {

    protected Name name;
    protected Set<Customer> customers;
    protected Set<Pet> pets;
    protected Set<Seller> sellers;

    public Reception(ReceptionId entityId, Name name) {
        super(entityId);
        appendChange(new ReceptionCreated(name));
    }

    private Reception(ReceptionId receptionId){
        super(receptionId);
        subscribe(new ReceptionChange(this));
    }

    public static Reception from(ReceptionId receptionId, List<DomainEvent> events){
        var reception = new Reception(receptionId);
        events.forEach(reception::applyEvent);
        return reception;
    }

    public void addCustomer(CustomerId customerId, Name name, AmountMoney amountMoney){
        //Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(amountMoney);
        appendChange(new CustomerAdded(customerId, name, amountMoney)).apply();
    }

    public void updateCustomerData(CustomerId customerId, Name name, AmountMoney amountMoney){
        appendChange(new UpdatedCustomerData(customerId, name, amountMoney)).apply();
    }

    public Optional<Customer> getCustomerForId(CustomerId customerId){
        return customers()
                .stream()
                .filter(customer -> customer.identity().equals(customerId))
                .findFirst();
    }

    public void addSeller(SellerId entityId, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber, Name name) {
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(addres);
        Objects.requireNonNull(emailAddres);
        Objects.requireNonNull(cellPhoneNumber);
        Objects.requireNonNull(name);
        appendChange(new SellerAdded(entityId,addres,emailAddres,cellPhoneNumber,name)).apply();
    }

    public void updateSellerData(SellerId entityId, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber, Name name){
        appendChange(new UpdatedSellerData(entityId, addres, emailAddres, cellPhoneNumber, name)).apply();
    }

    public Optional<Seller> getSellerForId(SellerId sellerId){
        return sellers()
                .stream()
                .filter(seller -> seller.identity().equals(sellerId))
                .findFirst();
    }

    public void addPet(PetId entityId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight, Diagnosis diagnosis){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(petBreed);
        Objects.requireNonNull(petAge);
        Objects.requireNonNull(petWeight);
        Objects.requireNonNull(diagnosis);
        appendChange(new PetAdded(entityId,name, petBreed, petAge, petWeight, diagnosis)).apply();
    }

    public void modifyPetData(PetId petId, Name name, PetBreed petBreed, PetAge petAge, PetWeight petWeight){
        appendChange(new ModifiedPetData(petId,name, petBreed, petAge, petWeight)).apply();
    }

    public void modifyDiagnosi(PetId petId, Diagnosis diagnosis){
        appendChange(new ModifiedDiagnosis(petId,diagnosis)).apply();
    }

    public Optional<Pet> gePetForId(PetId petId){
        return pets()
                .stream()
                .filter(pet -> pet.identity().equals(petId))
                .findFirst();
    }

    public Name name() {
        return name;
    }

    public Set<Customer> customers() {
        return customers;
    }

    public Set<Pet> pets() {
        return pets;
    }

    public Set<Seller> sellers() {
        return sellers;
    }
}
