package co.istad.chanchhaya.ecommerce.order.domain.exception;

import co.istad.chanchhaya.ecommerce.domain.exception.DomainException;

public class OrderDomainException extends DomainException {

    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDomainException(String message) {
        super(message);
    }

}
