package com.resourceserver.emazontransactionsservice.domain.api;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;

public interface SupplyServicePort {
    void saveSupplyTransaction(SupplyReport supplyReport);
}
