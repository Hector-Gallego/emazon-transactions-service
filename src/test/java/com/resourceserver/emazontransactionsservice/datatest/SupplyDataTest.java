package com.resourceserver.emazontransactionsservice.datatest;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;

import java.time.LocalDateTime;

public class SupplyDataTest {

    public static Supply createInvalidSupply(){
        return new Supply(
                1L,
                "",
                -1,
                -10,
                LocalDateTime.now()
        );
    }

    public static Supply createValidSupply(){
        return new Supply(
                1L,
                "Add Supply",
                1,
                10,
                LocalDateTime.now()
        );
    }

}
