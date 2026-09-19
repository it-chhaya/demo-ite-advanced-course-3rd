package co.istad.chanchhaya.ecommerce.order.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CommandOrderItem(
        UUID productId,
        Integer quantity,
        BigDecimal price,
        BigDecimal subTotal
) {
}
