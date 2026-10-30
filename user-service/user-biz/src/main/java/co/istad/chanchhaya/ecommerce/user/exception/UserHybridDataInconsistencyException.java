package co.istad.chanchhaya.ecommerce.user.exception;

import co.istad.chanchhaya.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserHybridDataInconsistencyException extends GlobalException {
    public UserHybridDataInconsistencyException(HttpStatus status, String message) {
        super(status, message);
    }
}
