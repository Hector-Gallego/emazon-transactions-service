package com.resourceserver.emazontransactionsservice.domain.model;

import java.util.List;

public class SaleRequest {

    private List<CartItem> cartItemList;

    public SaleRequest() {
    }

    public SaleRequest(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
