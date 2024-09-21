package com.resourceserver.emazontransactionsservice.datatest;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;

import java.time.LocalDateTime;

public class SupplyDataTestFactory {

    public static Supply createInvalidSupply(){
        return new Supply(
                1L,
                -1L,
                -10,
                "",
                -1L,
                LocalDateTime.now()
        );
    }

    public static Supply createValidSupply(){
        return new Supply(
                1L,
                1L,
                10,
                "Name article",
                1L,
                LocalDateTime.now()
        );
    }

}
