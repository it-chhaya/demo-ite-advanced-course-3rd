package co.istad.chanchhaya.ecommerce.order.domain.service;

import co.istad.chanchhaya.ecommerce.order.domain.entity.Business;
import co.istad.chanchhaya.ecommerce.order.domain.entity.Order;
import co.istad.chanchhaya.ecommerce.order.domain.event.OrderCancelledEvent;
import co.istad.chanchhaya.ecommerce.order.domain.event.OrderCreatedEvent;
import co.istad.chanchhaya.ecommerce.order.domain.event.OrderPaidEvent;

import java.util.List;

public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Business business) {
        return null;
    }

    @Override
    public OrderPaidEvent payOrder(Order order) {
        return null;
    }

    @Override
    public void approveOrder(Order order) {

    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        return null;
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {

    }
}
