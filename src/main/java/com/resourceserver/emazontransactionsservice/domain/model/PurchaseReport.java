package com.resourceserver.emazontransactionsservice.domain.model;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseReport {

    private List<PurchaseReportItem> itemsSaleData;
    private BigDecimal totalPurchase;

    public PurchaseReport() {
    }

    public PurchaseReport(List<PurchaseReportItem> itemsSaleData, BigDecimal totalPurchase) {
        this.itemsSaleData = itemsSaleData;
        this.totalPurchase = totalPurchase;
    }

    public List<PurchaseReportItem> getItemsSaleData() {
        return itemsSaleData;
    }

    public void setItemsSaleData(List<PurchaseReportItem> itemsSaleData) {
        this.itemsSaleData = itemsSaleData;
    }

    public BigDecimal getTotalPurchase() {
        return totalPurchase;
    }

    public void setTotalPurchase(BigDecimal totalPurchase) {
        this.totalPurchase = totalPurchase;
    }

    @Override
    public String toString() {
        return "SaleData{" +
                "itemsSaleData=" + itemsSaleData +
                ", totalPurchase=" + totalPurchase +
                '}';
    }
}
