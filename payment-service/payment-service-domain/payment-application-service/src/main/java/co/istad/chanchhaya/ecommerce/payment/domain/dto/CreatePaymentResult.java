package co.istad.chanchhaya.ecommerce.payment.domain.dto;

import co.istad.chanchhaya.ecommerce.domain.valueobject.PaymentStatus;

import java.util.UUID;

public record CreatePaymentResult(
        UUID paymentId,
        PaymentStatus paymentStatus
) {
}
