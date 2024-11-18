package com.resourceserver.emazontransactionsservice.domain.constants;
public class ErrorMessageConstants {

    private ErrorMessageConstants() {
        throw new IllegalStateException();
    }
    public static final String STOCK_UPDATE_ERROR = "Failed to update stock on the stock server.";
    public static final String SUPPLY_ORCHESTRATION_ERROR = "Error occurred during supply orchestration process.";
    public static final String TRANSACTION_CREATION_ERROR = "Failed to create transaction in the transactions server.";

    public static final String INVALID_FIELDS = "One or more fields are invalid.";
    public static final String ARTICLE_NAME_MESSAGE_ERROR = "Article name cannot be empty or null.";
    public static final String ARTICLE_ID_MESSAGE_ERROR = "Article id cannot be empty or null.";
    public static final String ARTICLE_QUANTITY_MESSAGE_ERROR = "Article quantity cannot be empty or null.";

    public static final String FETCH_CART_ITEMS_ERROR = "Error fetching items from the shopping cart";
    public static final String UPDATE_STOCK_ERROR = "Error updating stock";
    public static final String CLEAR_CART_ERROR = "Error clearing the shopping cart";
    public static final String SAVE_REPORT_ERROR = "Error saving the purchase report";
    public static final String STOCK_COMPENSATION_ERROR = "Error compensating stock";
    public static final String ADD_ITEMS_COMPENSATION_ERROR = "Error adding items to the shopping cart during compensation";
    public static final String ORCHESTRATOR_GENERIC_ERROR = "An error occurred during the purchase transaction orchestration";

    public static final String SUPPLY_VALIDATION_FAILED_ERROR_MESSAGE = "Supply validation failed due to the following errors.";
    public static final String QUANTITY_MUST_BE_GREATER_THAN_ONE = "Quantity must be greater than one.";
    public static final String NAME_MUST_NOT_BE_NULL_OR_EMPTY = "Name must not be null or empty.";

}
