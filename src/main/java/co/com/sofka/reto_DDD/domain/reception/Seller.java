package co.com.sofka.reto_DDD.domain.reception;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.genericvalue.*;
import co.com.sofka.reto_DDD.domain.reception.value.SellerId;

public class Seller extends Entity<SellerId> {

    private Addres addres;
    private EmailAddres emailAddres;
    private CellPhoneNumber cellPhoneNumber;
    private Name name;

    public Seller(SellerId entityId, Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber, Name name) {
        super(entityId);
        this.addres = addres;
        this.emailAddres = emailAddres;
        this.cellPhoneNumber = cellPhoneNumber;
        this.name = name;
    }

    public void updateSellerData(Addres addres, EmailAddres emailAddres, CellPhoneNumber cellPhoneNumber, Name name){
        this.addres = addres;
        this.emailAddres = emailAddres;
        this.cellPhoneNumber = cellPhoneNumber;
        this.name = name;
    }

    public Addres addres() {
        return addres;
    }

    public EmailAddres emailAddres() {
        return emailAddres;
    }

    public CellPhoneNumber cellPhoneNumber() {
        return cellPhoneNumber;
    }

    public Name came() {
        return name;
    }
}
