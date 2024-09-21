package com.resourceserver.emazontransactionsservice.domain.spi;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;

public interface SupplyPersistencePort {
    void saveSupplyTransaction(Supply supply);
}
