package com.resourceserver.emazontransactionsservice.configuration.constants;

public final class ErrorMessageConstants {
    private ErrorMessageConstants() {
        throw new IllegalStateException();
    }

    public static final String BAD_REQUEST_ERROR_MESSAGE = "The request could not be processed due to invalid input.";
    public static final String GENERIC_ERROR_MESSAGE = "An unexpected error occurred. Please try again later.";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE= "An internal server error occurred. Please contact support.";
    public static final String NOT_FOUND_ERROR_MESSAGE = "The requested resource was not found.";
    public static final String UNAUTHORIZED_ERROR_MESSAGE = "You are not authorized to access this resource.";
    public static final String ACCESS_DENIED_ERROR_MESSAGE = "Access to the requested resource is denied.";

}
