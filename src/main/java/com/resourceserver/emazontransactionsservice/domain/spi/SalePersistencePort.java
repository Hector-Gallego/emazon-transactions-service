package com.resourceserver.emazontransactionsservice.domain.spi;

import com.resourceserver.emazontransactionsservice.domain.model.Sale;

public interface SalePersistencePort {
    Sale saveSale(Sale sale);
    void deleteSale(Long id);
}
