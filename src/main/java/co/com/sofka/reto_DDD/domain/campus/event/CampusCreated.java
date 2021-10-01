package co.com.sofka.reto_DDD.domain.campus.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class CampusCreated extends DomainEvent {

    private final Name name;
    private final CellPhoneNumber cellPhoneNumber;
    private final Addres addres;

    public CampusCreated(Name name, CellPhoneNumber cellPhoneNumber, Addres addres) {
        super("sofka.reception.CampusCreated");
        this.name = name;
        this.cellPhoneNumber = cellPhoneNumber;
        this.addres = addres;
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
}
