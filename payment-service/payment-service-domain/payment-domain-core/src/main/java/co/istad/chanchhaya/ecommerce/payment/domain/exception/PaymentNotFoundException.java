package co.istad.chanchhaya.ecommerce.payment.domain.exception;

import co.istad.chanchhaya.ecommerce.domain.exception.DomainException;

public class PaymentNotFoundException extends DomainException {

    public PaymentNotFoundException(String message) {
        super(message);
    }

    public PaymentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
