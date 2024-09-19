package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions;

import com.resourceserver.emazontransactionsservice.configuration.constants.ErrorMessageConstants;

public class BadRequestException extends RuntimeException{

    public BadRequestException() {
        super(ErrorMessageConstants.BAD_REQUEST_ERROR_MESSAGE);
    }
}
