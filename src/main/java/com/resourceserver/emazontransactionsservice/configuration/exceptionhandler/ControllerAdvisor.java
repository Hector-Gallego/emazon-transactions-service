package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler;

import com.resourceserver.emazontransactionsservice.domain.exception.SupplyValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SupplyValidationException.class)
    public ResponseEntity<CustomErrorResponse> handleSupplyValidationException(SupplyValidationException exception) {
        return buildErrorResponse(exception, HttpStatus.BAD_REQUEST, exception.getErrors());
    }

    @ExceptionHandler(InvalidBearerTokenException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidBearerTokenException(InvalidBearerTokenException exception) {
        return buildErrorResponse(exception, HttpStatus.UNAUTHORIZED, Collections.emptyList());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<CustomErrorResponse> handleAccessDeniedException(AccessDeniedException exception){
        return  buildErrorResponse(exception, HttpStatus.FORBIDDEN, Collections.emptyList());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> handleBadCredentialsException(BadCredentialsException exception){
        return  buildErrorResponse(exception, HttpStatus.UNAUTHORIZED, Collections.emptyList());
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<CustomErrorResponse> handleBadCredentialsException(InsufficientAuthenticationException exception){
        return  buildErrorResponse(exception, HttpStatus.UNAUTHORIZED, Collections.emptyList());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<CustomErrorResponse> handleRuntimeException(RuntimeException exception){
        return  buildErrorResponse(exception, HttpStatus.BAD_REQUEST, Collections.emptyList());
    }

    private ResponseEntity<CustomErrorResponse> buildErrorResponse(Exception exception, HttpStatus status, List<String> errors) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                status.value(),
                exception.getMessage(),
                errors,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorResponse, status);
    }

}
