package com.resourceserver.emazontransactionsservice.domain.api;

import com.resourceserver.emazontransactionsservice.domain.model.SaleReport;

public interface SaleServicePort {

    Long saveSaleTransactionReport(SaleReport saleReport);
    void deleteSale(Long id);
}
