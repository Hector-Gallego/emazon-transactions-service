package com.resourceserver.emazontransactionsservice.domain.feign;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;

public interface SupplyTransactionFeignPort {
    void saveSupplyTransaction(SupplyReport supplyReport);
}
