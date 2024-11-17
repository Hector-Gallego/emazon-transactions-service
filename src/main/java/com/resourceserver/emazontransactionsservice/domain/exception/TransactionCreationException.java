package com.resourceserver.emazontransactionsservice.domain.exception;

import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessageConstants;

public class TransactionCreationException extends RuntimeException{

    public TransactionCreationException() {
        super(ErrorMessageConstants.TRANSACTION_CREATION_ERROR);
    }
}