package com.resourceserver.emazontransactionsservice.domain.exception;

import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessagesConstants;
import java.util.List;

public class SupplyValidationException extends RuntimeException{

    private final List<String> errors;

    public SupplyValidationException( List<String>  errors){
        super(ErrorMessagesConstants.SUPPLY_VALIDATION_FAILED_ERROR_MESSAGE);
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

}
