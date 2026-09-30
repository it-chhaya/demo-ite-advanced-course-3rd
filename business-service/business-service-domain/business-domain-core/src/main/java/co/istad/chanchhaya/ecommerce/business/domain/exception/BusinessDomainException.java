package co.istad.chanchhaya.ecommerce.business.domain.exception;

import co.istad.chanchhaya.ecommerce.domain.exception.DomainException;

public class BusinessDomainException extends DomainException {

    public BusinessDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessDomainException(String message) {
        super(message);
    }
}
