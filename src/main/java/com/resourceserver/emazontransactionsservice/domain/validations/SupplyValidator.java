package com.resourceserver.emazontransactionsservice.domain.validations;

import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessagesConstants;
import com.resourceserver.emazontransactionsservice.domain.exception.SupplyValidationException;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class  SupplyValidator {



    public static void validateSupply(Supply supply){
        List<String> errors = new ArrayList<>();
        validateArticleId(supply.getArticleId(), errors);
        validateName(supply.getName(), errors);
        validateQuantity(supply.getQuantity(), errors);

        if(Boolean.FALSE.equals(errors.isEmpty())){
            throw new SupplyValidationException(errors);
        }
    }

    public static void validateQuantity(Integer quantity, List<String> errors){
        if(quantity < 0){
            errors.add(ErrorMessagesConstants.QUANTITY_MUST_BE_GREATER_THAN_ZERO);
        }
    }

    public static void validateArticleId(Integer articleId, List<String> errors){
        if(articleId < 0){
            errors.add(ErrorMessagesConstants.ARTICLE_ID_MUST_BE_GREATER_THAN_ZERO);
        }
    }

    public static void validateName(String name, List<String> errors){
        if(name == null || name.isEmpty()){
            errors.add(ErrorMessagesConstants.NAME_MUST_NOT_BE_NULL_OR_EMPTY);
        }
    }




}
