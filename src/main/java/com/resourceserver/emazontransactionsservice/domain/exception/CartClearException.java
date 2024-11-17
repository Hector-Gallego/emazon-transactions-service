package com.resourceserver.emazontransactionsservice.domain.exception;

public class CartClearException extends RuntimeException{

    public CartClearException(String message) {
        super(message);
    }
}
