package co.com.sofka.reto_DDD.domain.reception.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.SellerId;

public class UpdatedSellerData extends DomainEvent {

    private final SellerId entityId;
    private final Addres addres;
    private final EmailAddres emailAddres;
    private final CellPhoneNumber cellPhoneNumber;
    private final Name name;

    public UpdatedSellerData(SellerId entityId, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber, Name name) {
        super("sofka.reception.updatedsellerdata");
        this.entityId = entityId;
        this.addres = addres;
        this.emailAddres = emailAddres;
        this.cellPhoneNumber = cellPhoneNumber;
        this.name = name;
    }

    public SellerId getEntityId() {
        return entityId;
    }

    public Addres getAddres() {
        return addres;
    }

    public EmailAddres getEmailAddres() {
        return emailAddres;
    }

    public CellPhoneNumber getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public Name getName() {
        return name;
    }
}
