package co.istad.chanchhaya.ecommerce.order.domain.dto;

import co.istad.chanchhaya.ecommerce.domain.valueobject.OrderId;

import java.util.UUID;

public record CreateOrderResult(
        UUID orderId
) {
}
