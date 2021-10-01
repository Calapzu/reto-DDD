package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.reto_DDD.domain.campus.event.CampusCreated;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;

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

    public Name getName() {
        return name;
    }

    public CellPhoneNumber getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public Addres getAddres() {
        return addres;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<Service> getServices() {
        return services;
    }

    public Set<VeterinaryDoctor> getVeterinaryDoctors() {
        return veterinaryDoctors;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }
}
