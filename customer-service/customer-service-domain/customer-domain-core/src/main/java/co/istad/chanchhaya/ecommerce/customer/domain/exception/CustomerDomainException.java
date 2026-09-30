package co.istad.chanchhaya.ecommerce.customer.domain.exception;

import co.istad.chanchhaya.ecommerce.domain.exception.DomainException;

public class CustomerDomainException extends DomainException {

    public CustomerDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerDomainException(String message) {
        super(message);
    }
}
