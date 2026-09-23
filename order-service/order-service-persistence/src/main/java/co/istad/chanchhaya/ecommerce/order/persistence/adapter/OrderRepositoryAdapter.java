package co.istad.chanchhaya.ecommerce.order.persistence.adapter;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Order;
import co.istad.chanchhaya.ecommerce.order.domain.port.ouput.OrderRepository;
import co.istad.chanchhaya.ecommerce.order.persistence.entity.OrderEntity;
import co.istad.chanchhaya.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import co.istad.chanchhaya.ecommerce.order.persistence.repository.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        // Map Order to OrderEntity
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);
        // Save into database
        orderEntity = orderJpaRepository.save(orderEntity);
        // Map OrderEntity to Order
        return orderPersistenceMapper.orderEntityToOrder(orderEntity);
    }

}
