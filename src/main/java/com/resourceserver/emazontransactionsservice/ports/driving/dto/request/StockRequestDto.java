package com.resourceserver.emazontransactionsservice.ports.driving.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StockRequestDto {

    private Long articleId;
    private Integer quantity;
}