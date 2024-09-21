package com.resourceserver.emazontransactionsservice.configuration.security.constants;

public class SecurityConstants {
    private SecurityConstants(){
        throw new IllegalStateException();
    }

    public static final String CLAIM_FIELD_NAME_ROLE = "role";
    public static final String EMPTY_FIELD = "";
    public static final String CLAIM_FIELD_NAME_USER_ID = "userId";
}
