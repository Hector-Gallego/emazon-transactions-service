package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions;

import com.resourceserver.emazontransactionsservice.configuration.constants.ErrorMessageConstants;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException() {
        super(ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE);
    }
}
