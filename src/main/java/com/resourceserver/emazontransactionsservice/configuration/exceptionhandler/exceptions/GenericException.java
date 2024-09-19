package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions;

import com.resourceserver.emazontransactionsservice.configuration.constants.ErrorMessageConstants;

public class GenericException extends RuntimeException{
    public GenericException() {
        super(ErrorMessageConstants.GENERIC_ERROR_MESSAGE);
    }
}
