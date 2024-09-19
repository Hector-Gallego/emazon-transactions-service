package com.resourceserver.emazontransactionsservice.domain.model;

import java.time.LocalDateTime;

public class Supply {

    private Long id;
    private String name;
    private Integer articleId;
    private Integer quantity;
    private LocalDateTime transactionDate;

    public Supply() {
    }

    public Supply(Long id, String name, Integer articleId, Integer quantity, LocalDateTime transactionDate) {
        this.id = id;
        this.name = name;
        this.articleId = articleId;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
