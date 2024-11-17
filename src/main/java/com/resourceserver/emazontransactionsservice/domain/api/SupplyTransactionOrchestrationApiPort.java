package com.resourceserver.emazontransactionsservice.domain.api;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;

public interface SupplyTransactionOrchestrationApiPort {

    void orchestrateSupplyTransaction(SupplyTransactionDetails supplyTransactionDetails);
}
