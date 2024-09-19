package com.resourceserver.emazontransactionsservice.domain.feign;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;

public interface StockFeignPort {
    void addSupply(Supply supply);
}
