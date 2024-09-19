package com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.exceptions;

import com.resourceserver.emazontransactionsservice.configuration.constants.ErrorMessageConstants;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super(ErrorMessageConstants.NOT_FOUND_ERROR_MESSAGE);
    }

}
