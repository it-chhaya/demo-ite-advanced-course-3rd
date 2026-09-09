package co.istad.chanchhaya.ecommerce.domain.dto;

import co.istad.chanchhaya.ecommerce.domain.valueobject.OrderId;

public record CreateOrderResponse(
        OrderId orderId
) {
}
