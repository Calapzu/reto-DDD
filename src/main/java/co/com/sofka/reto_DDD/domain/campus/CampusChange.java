package co.com.sofka.reto_DDD.domain.campus;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto_DDD.domain.campus.event.*;

import java.util.HashSet;

public class CampusChange extends EventChange {
    public CampusChange(Campus campus) {
        apply((CampusCreated event) -> {
            campus.name = event.getName();
            campus.cellPhoneNumber = event.getCellPhoneNumber();
            campus.addres = event.getAddres();

            campus.products = new HashSet<>();
            campus.veterinaryDoctors = new HashSet<>();
            campus.services = new HashSet<>();
        });

        apply((AssociatedReception event) -> {
            campus.receptionId = event.getReceptionId();
        });

        apply((AddedProduct event) -> {
            campus.products.add(new Product(event.getProductId(), event.getName(), event.getProductPrice(), event.getProductQuantity()));
        });

        apply((UpdatedProductData event) -> {
            var product = campus.getProductForId(event.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe el producto con Id "+event.getProductId()));
            product.updateProductData(event.getName(), event.getProductPrice(), event.getProductQuantity());
        });

        apply((AddedService event) -> {
            campus.services.add(new Service(event.getServiceId(), event.getDescription()));
        });

        apply((UpdatedDescription event) -> {
            var service = campus .getServiceForId(event.getServiceId())
                    .orElseThrow(() -> new IllegalArgumentException("No existe el servicio con Id "+event.getServiceId()));
            service.updateDescription(event.getDescription());
        });

        apply((AddedVeterinaryDoctor event ) -> {
            campus.veterinaryDoctors.add(new VeterinaryDoctor(event.getVeterinaryDoctorId(), event.getName(), event.getEmailAddres(), event.getAddres(), event.getCellPhoneNumber()));
        });

        apply((UpdatedVeterinaryDoctorData event) -> {
            var veterinaryDoctor = campus.getVeterinaryDoctorForId(event.getVeterinaryDoctorId())
                    .orElseThrow(()-> new IllegalArgumentException("No existe el medico veterinario con Id "+event.getVeterinaryDoctorId()));
            veterinaryDoctor.UpdateVeterinaryDoctorData(event.getName(), event.getEmailAddres(), event.getAddres(), event.getCellPhoneNumber());
        });
    }
}
