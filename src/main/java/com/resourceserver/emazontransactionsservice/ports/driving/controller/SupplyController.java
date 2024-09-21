package com.resourceserver.emazontransactionsservice.ports.driving.controller;

import com.resourceserver.emazontransactionsservice.configuration.exceptionhandler.CustomErrorResponse;
import com.resourceserver.emazontransactionsservice.domain.api.SupplyServicePort;
import com.resourceserver.emazontransactionsservice.ports.driving.constants.MessageConstants;
import com.resourceserver.emazontransactionsservice.configuration.openapi.costants.OpenApiConstants;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.SupplyRequestDto;
import com.resourceserver.emazontransactionsservice.ports.driving.mapper.SupplyToSupplyDtoMapper;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.response.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/supply")
public class SupplyController {

    private final SupplyServicePort supplyServicePort;
    private final SupplyToSupplyDtoMapper supplyDtoMapper;

    public SupplyController(SupplyServicePort supplyServicePort, SupplyToSupplyDtoMapper supplyDtoMapper) {
        this.supplyServicePort = supplyServicePort;
        this.supplyDtoMapper = supplyDtoMapper;
    }


    @Operation(summary = OpenApiConstants.OPENAPI_ADD_SUPPLY_SUMMARY,
            description = OpenApiConstants.OPENAPI_ADD_SUPPLY_DESCRIPTION)

    @ApiResponses(value = {
            @ApiResponse(responseCode = OpenApiConstants.OPENAPI_CODE_200,
                    description = OpenApiConstants.SUPPLY_ADDED,
                    content = @Content(mediaType = OpenApiConstants.OPENAPI_MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = CustomApiResponse.class))),
            @ApiResponse(responseCode = OpenApiConstants.OPENAPI_CODE_400,
                    description = OpenApiConstants.INVALID_INPUT,
                    content = @Content(mediaType = OpenApiConstants.OPENAPI_MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = CustomErrorResponse.class))),
            @ApiResponse(responseCode = OpenApiConstants.OPENAPI_CODE_500,
                    description = OpenApiConstants.OPENAPI_INTERNAL_SERVER_ERROR,
                    content = @Content(mediaType = OpenApiConstants.OPENAPI_MEDIA_TYPE_JSON,
                            schema = @Schema(implementation = CustomErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<CustomApiResponse> addSupplyAndSaveTransaction(@RequestBody SupplyRequestDto supplyDto) {

        supplyServicePort.saveSupplyTransaction(supplyDtoMapper.toDomain(supplyDto));

        CustomApiResponse response = new CustomApiResponse(
                HttpStatus.OK.value(),
                MessageConstants.SUPPLY_ADDED_SUCCESS,
                LocalDateTime.now()
        );

        return ResponseEntity.ok().body(response);

    }
}
