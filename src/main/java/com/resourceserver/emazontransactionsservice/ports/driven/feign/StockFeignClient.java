package com.resourceserver.emazontransactionsservice.ports.driven.feign;

import com.resourceserver.emazontransactionsservice.ports.driving.dto.SupplyRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="stock-service", url = "http://localhost:8080")
public interface StockFeignClient {

    @PutMapping("/api/article/stock")
    void addStock(@RequestBody SupplyRequestDto supplyRequestDto);
}
