package co.com.sofka.reto_DDD.domain.campus.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto_DDD.domain.campus.value.ProductId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductPrice;
import co.com.sofka.reto_DDD.domain.campus.value.ProductQuantity;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class UpdatedProductData extends DomainEvent {

    private final ProductId productId;
    private final Name name;
    private final ProductPrice productPrice;
    private final ProductQuantity productQuantity;

    public UpdatedProductData(ProductId productId, Name name, ProductPrice productPrice, ProductQuantity productQuantity) {
        super("sofka.campus.updatedproductdata");
        this.productId = productId;
        this.name = name;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
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
