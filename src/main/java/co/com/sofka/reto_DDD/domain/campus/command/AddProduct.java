package co.com.sofka.reto_DDD.domain.campus.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto_DDD.domain.campus.value.CampusId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductPrice;
import co.com.sofka.reto_DDD.domain.campus.value.ProductQuantity;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class AddProduct extends Command {

    private final CampusId campusId;
    private final ProductId productId;
    private final Name name;
    private final ProductPrice productPrice;
    private final ProductQuantity productQuantity;

    public AddProduct(CampusId campusId, ProductId productId, Name name, ProductPrice productPrice, ProductQuantity productQuantity) {
        this.campusId = campusId;
        this.productId = productId;
        this.name = name;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public CampusId getCampusId() {
        return campusId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public ProductQuantity getProductQuantity() {
        return productQuantity;
    }
}
