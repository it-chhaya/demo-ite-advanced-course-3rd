package co.istad.chanchhaya.ecommerce.payment.persistence.payment.adapter;

import co.istad.chanchhaya.ecommerce.payment.persistence.payment.mapper.PaymentPersistenceMapper;
import co.istad.chanchhaya.ecommerce.payment.persistence.payment.repository.PaymentJpaRepository;
import co.istad.chanchhaya.ecommerce.payment.domain.entity.Payment;
import co.istad.chanchhaya.ecommerce.payment.domain.ports.output.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentPersistenceMapper paymentPersistenceMapper;

    @Override
    public Payment save(Payment payment) {
        return paymentPersistenceMapper
                .paymentEntityToPayment(paymentJpaRepository
                        .save(paymentPersistenceMapper.paymentToPaymentEntity(payment)));
    }

    @Override
    public Optional<Payment> findByOrderId(UUID orderId) {
        return paymentJpaRepository.findByOrderId(orderId)
                .map(paymentPersistenceMapper::paymentEntityToPayment);
    }
}
