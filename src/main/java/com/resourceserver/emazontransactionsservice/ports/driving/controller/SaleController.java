package com.resourceserver.emazontransactionsservice.ports.driving.controller;

import com.resourceserver.emazontransactionsservice.domain.api.SaleServicePort;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.SaleRequestDto;
import com.resourceserver.emazontransactionsservice.ports.driving.mapper.SaleToSaleDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final SaleServicePort saleServicePort;
    private final SaleToSaleDtoMapper saleDtoMapper;

    public SaleController(SaleServicePort saleServicePort, SaleToSaleDtoMapper saleDtoMapper) {
        this.saleServicePort = saleServicePort;
        this.saleDtoMapper = saleDtoMapper;
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody SaleRequestDto saleRequestDto){
        Long saleSaveId = saleServicePort.saveSale(saleDtoMapper.toDomain(saleRequestDto));
        return ResponseEntity.ok().body(saleSaveId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSaleTransaction(@PathVariable Long id){
        saleServicePort.deleteSale(id);
        return ResponseEntity.ok().build();
    }
}
