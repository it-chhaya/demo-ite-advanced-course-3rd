package co.istad.chanchhaya.ecommerce.order.domain.port.input;

import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {

    void execute(CreateOrderRequest createOrderRequest);

}
