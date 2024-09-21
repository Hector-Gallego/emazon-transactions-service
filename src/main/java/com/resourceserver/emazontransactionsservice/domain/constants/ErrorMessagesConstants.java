package com.resourceserver.emazontransactionsservice.domain.constants;

public final class ErrorMessagesConstants {

    private ErrorMessagesConstants(){
        throw new IllegalStateException();
    }

    public static final String SUPPLY_VALIDATION_FAILED_ERROR_MESSAGE = "Supply validation failed due to the following errors.";
    public static final String QUANTITY_MUST_BE_GREATER_THAN_ONE = "Quantity must be greater than one.";
    public static final String NAME_MUST_NOT_BE_NULL_OR_EMPTY = "Name must not be null or empty.";

}
