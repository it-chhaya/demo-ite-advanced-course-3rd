package co.istad.chanchhaya.ecommerce.order.domain.dto;

import co.istad.chanchhaya.ecommerce.domain.valueobject.OrderId;

public record CreateOrderResponse(
        OrderId orderId
) {
}
