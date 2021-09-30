package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto_DDD.domain.campus.value.ProductId;

public class Product extends Entity<ProductId> {

    public Product(ProductId entityId) {
        super(entityId);
    }
}
