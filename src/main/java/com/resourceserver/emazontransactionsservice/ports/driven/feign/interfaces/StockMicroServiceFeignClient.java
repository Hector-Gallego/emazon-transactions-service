package com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces;


import com.resourceserver.emazontransactionsservice.domain.model.CartItem;
import com.resourceserver.emazontransactionsservice.domain.model.SaleData;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.constants.MicroServicesDataConstants;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.StockRequestDto;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.response.CustomApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = MicroServicesDataConstants.STOCK_MICROSERVICE_NAME,
        url = MicroServicesDataConstants.STOCK_MICROSERVICE_URL)
public interface StockMicroServiceFeignClient {

    @PutMapping("/api/stock")
    ResponseEntity<CustomApiResponse> addSupply(@RequestBody StockRequestDto stockRequestDto);

    @PostMapping("/api/stock/update")
    ResponseEntity<SaleData> updateStockAndGetSaleData(@RequestBody List<CartItem> cartItems);

    @PostMapping("api/stock/updateCompensation")
    ResponseEntity<Void> updateStockCompensation(@RequestBody List<CartItem> cartItems);
}