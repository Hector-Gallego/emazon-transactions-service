package com.resourceserver.emazontransactionsservice.ports.driving.constants;

public final class MessageConstants {

    private MessageConstants(){
        throw new IllegalStateException();
    }

    public static final String SUPPLY_ADDED_SUCCESS = "Supply transaction completed successfully. Article stock has been updated.";
    public static final String NAME_NOT_NULL_OR_BLANK = "The name cannot be null or blank.";
    public static final String QUANTITY_NOT_NULL_OR_BLANK = "The quantity cannot be null or blank.";
    public static final String ARTICLE_ID_NOT_NULL_OR_BLANK = "The article ID cannot be null or blank.";

}
