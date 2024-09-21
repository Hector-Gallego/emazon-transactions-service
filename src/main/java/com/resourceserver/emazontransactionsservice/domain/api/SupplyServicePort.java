package com.resourceserver.emazontransactionsservice.domain.api;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;

public interface SupplyServicePort {
    void saveSupplyTransaction(Supply supply);
}
