package co.istad.chanchhaya.ecommerce.domain.event;

import co.istad.chanchhaya.ecommerce.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCancelledEvent extends OrderEvent{
    public OrderCancelledEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
