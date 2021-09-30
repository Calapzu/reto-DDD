package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.ProductId;
import co.com.sofka.reto_DDD.domain.campus.value.ProductPrice;
import co.com.sofka.reto_DDD.domain.campus.value.ProductQuantity;
import co.com.sofka.reto_DDD.domain.genericvalue.Name;

public class Product extends Entity<ProductId> {

    private Name name;
    private ProductPrice productPrice;
    private ProductQuantity productQuantity;

    public Product(ProductId entityId) {
        super(entityId);
    }
}
