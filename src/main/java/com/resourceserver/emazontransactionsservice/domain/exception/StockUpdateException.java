package com.resourceserver.emazontransactionsservice.domain.exception;


import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessageConstants;

public class StockUpdateException extends RuntimeException{
    public StockUpdateException(String message){
        super(message);
    }
}
