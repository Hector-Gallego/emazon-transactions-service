package com.resourceserver.emazontransactionsservice.domain.feign;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;

public interface SupplyTransactionFeignPort {
    void saveSupplyTransaction(Supply supply);
}
