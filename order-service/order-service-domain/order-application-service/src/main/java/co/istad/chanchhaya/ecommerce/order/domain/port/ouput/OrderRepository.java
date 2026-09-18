package co.istad.chanchhaya.ecommerce.order.domain.port.ouput;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Order;

public interface OrderRepository {

    Order saveOrder(Order order);

}
