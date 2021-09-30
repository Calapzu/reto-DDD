package co.com.sofka.reto_DDD.domain.reception.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.genericvalue.Addres;
import co.com.sofka.reto_DDD.domain.genericvalue.CellPhoneNumber;
import co.com.sofka.reto_DDD.domain.genericvalue.EmailAddres;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;
import co.com.sofka.reto_DDD.domain.reception.value.ReceptionId;
import co.com.sofka.reto_DDD.domain.reception.value.SellerId;

public class UpdateSellerData extends Command {

    private final ReceptionId receptionId;
    private final SellerId entityId;
    private final Addres addres;
    private final EmailAddres emailAddres;
    private final CellPhoneNumber cellPhoneNumber;
    private final Name name;

    public UpdateSellerData(ReceptionId receptionId, SellerId entityId, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber, Name name) {
        this.receptionId = receptionId;
        this.entityId = entityId;
        this.addres = addres;
        this.emailAddres = emailAddres;
        this.cellPhoneNumber = cellPhoneNumber;
        this.name = name;
    }

    public ReceptionId getReceptionId() {
        return receptionId;
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
