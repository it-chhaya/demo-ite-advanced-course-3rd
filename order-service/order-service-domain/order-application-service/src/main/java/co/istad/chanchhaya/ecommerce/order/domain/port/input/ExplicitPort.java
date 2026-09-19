package co.istad.chanchhaya.ecommerce.order.domain.port.input;

import co.istad.chanchhaya.ecommerce.order.domain.dto.CreateOrderCommand;

public interface ExplicitPort {

    void execute(CreateOrderCommand createOrderCommand);

}
