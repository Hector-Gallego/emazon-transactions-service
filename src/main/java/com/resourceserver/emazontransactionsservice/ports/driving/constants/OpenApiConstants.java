package com.resourceserver.emazontransactionsservice.ports.driving.constants;

public final class OpenApiConstants {


    public static final String OPENAPI_TITTLE = "Transactions microservice";
    public static final String OPENAPI_VERSION = "1.0";
    public static final String OPENAPI_DESCRIPTION = "Service for create transactions";

    private OpenApiConstants(){
        throw new IllegalStateException();
    }

    public static final String OPENAPI_ADD_SUPPLY_SUMMARY = "Add a new supply transaction";
    public static final String OPENAPI_ADD_SUPPLY_DESCRIPTION = "Endpoint to add a new supply, which updates the stock of the specified article.";
    public static final String SUPPLY_ADDED = "The supply has been successfully added, and the article stock has been updated.";
    public static final String OPENAPI_MEDIA_TYPE_JSON = "application/json";
    public static final String INVALID_INPUT = "The provided input is invalid. Please verify the article ID and quantity.";
    public static final String OPENAPI_INTERNAL_SERVER_ERROR = "An unexpected error occurred. Please try again later or contact support.";
    public static final String OPENAPI_CODE_500 = "500";
    public static final String OPENAPI_CODE_400 = "400";
    public static final String OPENAPI_CODE_200 = "200";

}
