package co.istad.chanchhaya.ecommerce.payment.domain.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CreatePaymentCommand(
        UUID orderId,
        UUID customerId,
        BigDecimal price
) {
}
