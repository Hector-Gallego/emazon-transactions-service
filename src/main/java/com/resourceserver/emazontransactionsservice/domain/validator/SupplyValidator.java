package com.resourceserver.emazontransactionsservice.domain.validator;

import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessagesConstants;
import com.resourceserver.emazontransactionsservice.domain.constants.ValidationConstants;
import com.resourceserver.emazontransactionsservice.domain.exception.SupplyValidationException;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class  SupplyValidator {

    private SupplyValidator(){
        throw new IllegalStateException();
    }
    public static void validateSupply(Supply supply){
        List<String> errors = new ArrayList<>();
        validateArticleName(supply.getArticleName(), errors);
        validateQuantity(supply.getQuantity(), errors);

        if(Boolean.FALSE.equals(errors.isEmpty())){
            throw new SupplyValidationException(errors);
        }
    }

    public static void validateQuantity(Integer quantity, List<String> errors){
        if(quantity < ValidationConstants.MIN_QUANTITY_VALUE){
            errors.add(ErrorMessagesConstants.QUANTITY_MUST_BE_GREATER_THAN_ONE);
        }
    }

    public static void validateArticleName(String name, List<String> errors){
        if(name == null || name.isEmpty()){
            errors.add(ErrorMessagesConstants.NAME_MUST_NOT_BE_NULL_OR_EMPTY);
        }
    }




}
