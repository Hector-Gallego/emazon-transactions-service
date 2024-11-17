package com.resourceserver.emazontransactionsservice.ports.driven.feign.constants;

public class MicroServicesDataConstants {
    private MicroServicesDataConstants(){
        throw new IllegalStateException();
    }

    public static final String STOCK_MICROSERVICE_NAME="emazon-stock-microservice";
    public static final String STOCK_MICROSERVICE_URL="http://localhost:8080";
    public static final String TRANSACTIONS_MICROSERVICE_NAME="emazon-transactions-microservice";
    public static final String TRANSACTIONS_MICROSERVICE_URL="http://localhost:8090";
    public static final String SHOPPING_CART_MICROSERVICE_CLIENT="emazon-shopping-cart-microservice";
    public static final String SHOPPING_CART_MICROSERVICE_URL="http://localhost:9020";
}

