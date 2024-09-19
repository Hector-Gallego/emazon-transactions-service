package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions;

import com.resourceserver.emazontransactionsservice.configuration.constants.ErrorMessageConstants;

public class AccessDeniedExceptions extends RuntimeException {

    public AccessDeniedExceptions(){
        super(ErrorMessageConstants.ACCESS_DENIED_ERROR_MESSAGE);
    }
}
