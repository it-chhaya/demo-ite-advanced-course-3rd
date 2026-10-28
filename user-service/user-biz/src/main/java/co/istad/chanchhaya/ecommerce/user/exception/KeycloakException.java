package co.istad.chanchhaya.ecommerce.user.exception;

import co.istad.chanchhaya.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class KeycloakException extends GlobalException {
    public KeycloakException(HttpStatus status, String message) {
        super(status, message);
    }
}
