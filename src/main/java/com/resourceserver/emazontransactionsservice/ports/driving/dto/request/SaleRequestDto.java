package com.resourceserver.emazontransactionsservice.ports.driving.dto.request;

import com.resourceserver.emazontransactionsservice.domain.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleRequestDto {
    private List<CartItem> cartItemList;
}
