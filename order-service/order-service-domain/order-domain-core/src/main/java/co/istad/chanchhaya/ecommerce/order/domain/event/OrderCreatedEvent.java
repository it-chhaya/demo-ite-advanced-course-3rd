package co.istad.chanchhaya.ecommerce.order.domain.event;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent {
    public OrderCreatedEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
