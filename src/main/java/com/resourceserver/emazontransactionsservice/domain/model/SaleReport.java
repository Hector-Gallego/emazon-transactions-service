package com.resourceserver.emazontransactionsservice.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class SaleReport {

    private Long id;
    private Long userId;
    private List<CartItem> cartItemList;
    private LocalDateTime saleDate;

    public SaleReport() {
    }

    public SaleReport(Long id, Long userId, List<CartItem> cartItemList, LocalDateTime saleDate) {
        this.id = id;
        this.userId = userId;
        this.cartItemList = cartItemList;
        this.saleDate = saleDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }
}
