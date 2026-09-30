package co.istad.chanchhaya.ecommerce.payment.domain;

import co.istad.chanchhaya.ecommerce.payment.domain.entity.CreditEntry;
import co.istad.chanchhaya.ecommerce.payment.domain.entity.CreditHistory;
import co.istad.chanchhaya.ecommerce.payment.domain.entity.Payment;
import co.istad.chanchhaya.ecommerce.payment.domain.event.PaymentEvent;

import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages);
}
