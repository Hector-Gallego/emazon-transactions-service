package com.resourceserver.emazontransactionsservice.domain.model;

import java.time.LocalDateTime;

public class SupplyReport {

    private Long id;
    private Long articleId;
    private Integer quantity;
    private String articleName;
    private Long userId;
    private LocalDateTime transactionDate;

    public SupplyReport() {
    }

    public SupplyReport(Long id, Long articleId, Integer quantity, String articleName, Long userId, LocalDateTime transactionDate) {
        this.id = id;
        this.articleId = articleId;
        this.quantity = quantity;
        this.articleName = articleName;
        this.userId = userId;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
