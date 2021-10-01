package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.ProductId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductPrice;
import co.com.sofka.reto_DDD.domain.campus.value.ProductQuantity;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

import java.util.Objects;

public class Product extends Entity<ProductId> {

    private Name name;
    private ProductPrice productPrice;
    private ProductQuantity productQuantity;

    public Product(ProductId entityId, Name name, ProductPrice productPrice, ProductQuantity productQuantity) {
        super(entityId);
        this.name = name;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public void updateProductData(Name name, ProductPrice productPrice, ProductQuantity productQuantity){
        this.name = Objects.requireNonNull(name);
        this.productPrice = Objects.requireNonNull(productPrice);
        this.productQuantity = Objects.requireNonNull(productQuantity);

    }

    public Name name() {
        return name;
    }

    public ProductPrice productPrice() {
        return productPrice;
    }

    public ProductQuantity productQuantity() {
        return productQuantity;
    }
}
