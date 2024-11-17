package com.resourceserver.emazontransactionsservice.domain.exception;

import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessageConstants;

public class SupplyOrchestrationException extends RuntimeException{

    public SupplyOrchestrationException(){
        super(ErrorMessageConstants.SUPPLY_ORCHESTRATION_ERROR);
    }
}
