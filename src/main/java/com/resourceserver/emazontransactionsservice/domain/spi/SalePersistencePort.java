package com.resourceserver.emazontransactionsservice.domain.spi;

import com.resourceserver.emazontransactionsservice.domain.model.SaleReport;

public interface SalePersistencePort {
    SaleReport saveSale(SaleReport saleReport);
    void deleteSale(Long id);
}
