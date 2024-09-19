package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions;

import com.resourceserver.emazontransactionsservice.configuration.constants.ErrorMessageConstants;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super(ErrorMessageConstants.UNAUTHORIZED_ERROR_MESSAGE);
    }
}
