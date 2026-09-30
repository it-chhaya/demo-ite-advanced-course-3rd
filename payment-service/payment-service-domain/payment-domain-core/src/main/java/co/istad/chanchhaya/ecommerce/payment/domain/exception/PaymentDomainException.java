package co.istad.chanchhaya.ecommerce.payment.domain.exception;

import co.istad.chanchhaya.ecommerce.domain.exception.DomainException;

public class PaymentDomainException extends DomainException {

    public PaymentDomainException(String message) {
        super(message);
    }

    public PaymentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
