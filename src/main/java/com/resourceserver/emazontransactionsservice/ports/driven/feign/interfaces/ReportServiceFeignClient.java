package com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces;

import com.resourceserver.emazontransactionsservice.domain.model.SaleData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "report-service",
        url = "http://localhost:9030")
public interface ReportServiceFeignClient {

    @PostMapping("/api/reports/saveReport")
    ResponseEntity<Long> saveReport(SaleData saleData);

    @DeleteMapping("api/reports/delete/report/{reportId}")
    ResponseEntity<Void> deleteReportById(@PathVariable Long reportId);
}
