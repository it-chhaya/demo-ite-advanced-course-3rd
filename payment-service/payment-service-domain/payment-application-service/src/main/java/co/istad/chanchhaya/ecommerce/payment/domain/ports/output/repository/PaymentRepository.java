package co.istad.chanchhaya.ecommerce.payment.domain.ports.output.repository;

import co.istad.chanchhaya.ecommerce.payment.domain.entity.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findByOrderId(UUID orderId);
}
