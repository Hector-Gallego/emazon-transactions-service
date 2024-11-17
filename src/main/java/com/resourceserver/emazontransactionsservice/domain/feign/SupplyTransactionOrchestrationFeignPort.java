package com.resourceserver.emazontransactionsservice.domain.feign;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;

public interface SupplyTransactionOrchestrationFeignPort {

    void orchestrateSupplyTransaction(SupplyTransactionDetails supplyTransactionDetails);

}
