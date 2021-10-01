package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.event.*;
import co.com.sofka.reto_DDD.domain.campus.value.*;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Campus extends AggregateEvent<CampusId> {

    protected Name name;
    protected CellPhoneNumber cellPhoneNumber;
    protected Addres addres;

    protected Set<Product> products;
    protected Set<Service> services;
    protected Set<VeterinaryDoctor> veterinaryDoctors;

    protected ReceptionId receptionId;


    public Campus(CampusId entityId, Name name, CellPhoneNumber cellPhoneNumber, Addres addres) {
        super(entityId);
        appendChange(new CampusCreated(name, cellPhoneNumber, addres)).apply();
    }

    private Campus(CampusId campusId){
        super(campusId);
        subscribe(new CampusChange(this));
    }

    public static Campus from(CampusId campusId, List<DomainEvent> events){
        var campus = new Campus(campusId);
        events.forEach(campus::applyEvent);
        return campus;
    }



    public void associateReception(ReceptionId receptionId){
        appendChange(new AssociatedReception(receptionId)).apply();
    }

    public void addVeterinaryDoctor(VeterinaryDoctorId veterinaryDoctorId, Name name, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber){
        Objects.requireNonNull(veterinaryDoctorId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(addres);
        Objects.requireNonNull(emailAddres);
        Objects.requireNonNull(cellPhoneNumber);
        appendChange(new AddedVeterinaryDoctor(veterinaryDoctorId,name,addres,emailAddres,cellPhoneNumber)).apply();
    }

    public void updateVeterinayDoctorData(VeterinaryDoctorId veterinaryDoctorId, Name name, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber){
        Objects.requireNonNull(veterinaryDoctorId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(addres);
        Objects.requireNonNull(emailAddres);
        Objects.requireNonNull(cellPhoneNumber);
        appendChange(new UpdatedVeterinaryDoctorData(veterinaryDoctorId, name, addres, emailAddres, cellPhoneNumber)).apply();
    }

    public Optional<VeterinaryDoctor> getVeterinaryDoctorForId(VeterinaryDoctorId veterinaryDoctorId){
        return veterinaryDoctors()
                .stream()
                .filter(veterinaryDoctor -> veterinaryDoctor.identity().equals(veterinaryDoctorId))
                .findFirst();
    }

    public void addService(ServiceId serviceId, Description description){
        Objects.requireNonNull(serviceId);
        Objects.requireNonNull(description);
        appendChange(new AddedService(serviceId, description)).apply();
    }

    public void updateDescription(ServiceId serviceId, Description description){
        Objects.requireNonNull(serviceId);
        Objects.requireNonNull(description);
        appendChange(new UpdatedDescription(serviceId, description)).apply();
    }

    public Optional<Service> getServiceForId(ServiceId serviceId){
        return services()
                .stream()
                .filter(service -> service.identity().equals(serviceId))
                .findFirst();
    }

    public void addProduct(ProductId productId, Name name, ProductPrice productPrice, ProductQuantity productQuantity){
        Objects.requireNonNull(productId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(productPrice);
        Objects.requireNonNull(productQuantity);
        appendChange(new AddedProduct(productId, name, productPrice, productQuantity)).apply();
    }

    public void updateProductData(ProductId productId, Name name, ProductPrice productPrice, ProductQuantity productQuantity){
        Objects.requireNonNull(productId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(productPrice);
        Objects.requireNonNull(productQuantity);
        appendChange(new UpdatedProductData(productId, name, productPrice, productQuantity)).apply();
    }

    public Optional<Product> getProductForId(ProductId productId){
        return products()
                .stream()
                .filter(product -> product.identity().equals(productId))
                .findFirst();
    }



    public Name mame() {
        return name;
    }

    public CellPhoneNumber cellPhoneNumber() {
        return cellPhoneNumber;
    }

    public Addres addres() {
        return addres;
    }

    public Set<Product> products() {
        return products;
    }

    public Set<Service> services() {
        return services;
    }

    public Set<VeterinaryDoctor> veterinaryDoctors() {
        return veterinaryDoctors;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }
}
