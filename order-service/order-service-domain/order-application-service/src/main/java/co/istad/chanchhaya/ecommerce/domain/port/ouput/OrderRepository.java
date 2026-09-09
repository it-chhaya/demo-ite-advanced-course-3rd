package co.istad.chanchhaya.ecommerce.domain.port.ouput;

import co.istad.chanchhaya.ecommerce.domain.entity.Order;

public interface OrderRepository {

    Order saveOrder(Order order);

}
