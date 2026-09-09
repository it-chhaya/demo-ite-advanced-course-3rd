package co.istad.chanchhaya.ecommerce.domain.port.input;

import co.istad.chanchhaya.ecommerce.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {

    void execute(CreateOrderRequest createOrderRequest);

}
