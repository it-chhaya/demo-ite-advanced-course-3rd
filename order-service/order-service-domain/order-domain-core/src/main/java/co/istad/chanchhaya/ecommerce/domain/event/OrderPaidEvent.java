package co.istad.chanchhaya.ecommerce.domain.event;

import co.istad.chanchhaya.ecommerce.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent{
    public OrderPaidEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
