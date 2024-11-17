package com.resourceserver.emazontransactionsservice.ports.driven.feign.dtos;

import com.resourceserver.emazontransactionsservice.ports.driving.constants.MessageConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SupplyRequestDto {

    @NotNull(message = MessageConstants.ARTICLE_ID_NOT_NULL_OR_BLANK )
    @NotBlank(message = MessageConstants.ARTICLE_ID_NOT_NULL_OR_BLANK)
    private Long articleId;

    @NotNull(message = MessageConstants.QUANTITY_NOT_NULL_OR_BLANK)
    @NotBlank(message = MessageConstants.QUANTITY_NOT_NULL_OR_BLANK)
    private Integer quantity;

    @NotNull(message = MessageConstants.NAME_NOT_NULL_OR_BLANK)
    @NotBlank(message = MessageConstants.NAME_NOT_NULL_OR_BLANK )
    private String articleName;
}
