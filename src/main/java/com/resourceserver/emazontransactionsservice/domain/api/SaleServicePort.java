package com.resourceserver.emazontransactionsservice.domain.api;

import com.resourceserver.emazontransactionsservice.domain.model.Sale;

public interface SaleServicePort {

    Long saveSale(Sale sale);
    void deleteSale(Long id);
}
