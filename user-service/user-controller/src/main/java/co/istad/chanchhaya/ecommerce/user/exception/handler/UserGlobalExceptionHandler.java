package co.istad.chanchhaya.ecommerce.user.exception.handler;

import co.istad.chanchhaya.ecommerce.restapi.dto.RestApiErrorResponse;
import co.istad.chanchhaya.ecommerce.restapi.exception.GlobalException;
import co.istad.chanchhaya.ecommerce.restapi.exception.GlobalExceptionHandler;
import co.istad.chanchhaya.ecommerce.user.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserGlobalExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(KeycloakException.class)
    public RestApiErrorResponse<?> handle(
            KeycloakException e
    ) {
        return build(e);
    }


    @ExceptionHandler(PasswordMismatchException.class)
    public RestApiErrorResponse<?> handle(
            PasswordMismatchException e
    ) {
        return build(e);
    }


    @ExceptionHandler(UsernameConflictException.class)
    public RestApiErrorResponse<?> handle(
            UsernameConflictException e
    ) {
        return build(e);
    }


    @ExceptionHandler(UserNotFoundException.class)
    public RestApiErrorResponse<?> handle(
            UserNotFoundException e
    ) {
        return build(e);
    }


    @ExceptionHandler(UserHybridDataInconsistencyException.class)
    public RestApiErrorResponse<?> handle(
            UserHybridDataInconsistencyException e
    ) {
        return build(e);
    }


    private RestApiErrorResponse<?> build(GlobalException e) {
        return RestApiErrorResponse.builder()
                .code(e.getStatus().getReasonPhrase())
                .message(e.getMessage())
                .build();
    }

}
