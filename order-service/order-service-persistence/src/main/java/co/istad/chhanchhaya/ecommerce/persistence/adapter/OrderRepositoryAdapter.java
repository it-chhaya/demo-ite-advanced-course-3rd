package co.istad.chhanchhaya.ecommerce.persistence.adapter;

import co.istad.chanchhaya.ecommerce.domain.entity.Order;
import co.istad.chanchhaya.ecommerce.domain.port.ouput.OrderRepository;
import co.istad.chhanchhaya.ecommerce.persistence.repository.OrderJpaRepository;

public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        // Map Order to OrderEntity
        // Map OrderEntity to Order
        return null;
    }

}
