package co.com.sofka.reto_DDD.domain.campus.value;

import co.com.sofka.domain.generic.Identity;

public class ProductId extends Identity {

    public ProductId() {
    }

    private ProductId(String id) {
        super(id);
    }

    public static ProductId of(String id){
        return new ProductId(id);
    }
}
