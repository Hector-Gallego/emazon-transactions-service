package com.resourceserver.emazontransactionsservice.datatest;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;

import java.time.LocalDateTime;

public class SupplyDataTestFactory {

    public static SupplyReport createInvalidSupply(){
        return new SupplyReport(
                1L,
                -1L,
                -10,
                "",
                -1L,
                LocalDateTime.now()
        );
    }

    public static SupplyReport createValidSupply(){
        return new SupplyReport(
                1L,
                1L,
                10,
                "Name article",
                1L,
                LocalDateTime.now()
        );
    }

}
