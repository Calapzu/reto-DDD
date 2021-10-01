package co.com.sofka.reto_DDD.usecases.usecasescampus;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto_DDD.domain.campus.Campus;
import co.com.sofka.reto_DDD.domain.campus.command.AddProduct;

public class AddProductUsesCases extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddProduct> addProductRequestCommand) {
        var command = addProductRequestCommand.getCommand();
        var product = Campus.from(command.getCampusId(), retrieveEvents(command.getCampusId().value()));
        product.addProduct(command.getProductId(), command.getName(), command.getProductPrice(), command.getProductQuantity());
        emit().onResponse(new ResponseEvents(product.getUncommittedChanges()));
    }
}
