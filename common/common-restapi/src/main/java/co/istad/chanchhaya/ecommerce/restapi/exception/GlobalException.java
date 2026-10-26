package co.istad.chanchhaya.ecommerce.restapi.exception;

import org.springframework.http.HttpStatus;

public class GlobalException extends RuntimeException {

    private final HttpStatus status;

    public HttpStatus getStatus() {
        return status;
    }

    public GlobalException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
