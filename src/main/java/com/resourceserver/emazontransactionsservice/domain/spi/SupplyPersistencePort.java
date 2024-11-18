package com.resourceserver.emazontransactionsservice.domain.spi;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;

public interface SupplyPersistencePort {
    void saveSupplyTransaction(SupplyReport supplyReport);
}
