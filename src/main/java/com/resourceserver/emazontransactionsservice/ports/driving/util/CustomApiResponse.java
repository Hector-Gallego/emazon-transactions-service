package com.resourceserver.emazontransactionsservice.ports.driving.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomApiResponse{
    private Integer status;
    private String message;
    private LocalDateTime timestamp;
}
