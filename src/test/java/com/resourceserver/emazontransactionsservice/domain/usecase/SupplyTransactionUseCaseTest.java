package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.datatest.SupplyDataTestFactory;
import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessagesConstants;
import com.resourceserver.emazontransactionsservice.domain.exception.SupplyValidationException;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.validator.SupplyValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SupplyTransactionUseCaseTest {

    @Mock
    private SupplyPersistencePort supplyPersistencePort;

    @Mock
    AuthenticatedManagerPort authenticatedManagerPort;


    @InjectMocks
    private SupplyTransactionUseCase supplyUseCase;

    @Test
    void shouldSaveSupplyTransactionSuccessfully() {

        Supply supply = SupplyDataTestFactory.createValidSupply();

        Long mockUserId = 1L;
        when(authenticatedManagerPort.getUserId()).thenReturn(mockUserId);
        supply.setUserId(mockUserId);

        supplyUseCase.saveSupplyTransaction(supply);

        verify(supplyPersistencePort, times(1)).saveSupplyTransaction(supply);
    }

    @Test
    void shouldThrowExceptionWhenSupplyValidationFails() {

        Supply supply = SupplyDataTestFactory.createInvalidSupply();
        List<String> expectedErros = List.of(
                ErrorMessagesConstants.NAME_MUST_NOT_BE_NULL_OR_EMPTY,
                ErrorMessagesConstants.QUANTITY_MUST_BE_GREATER_THAN_ONE
        );

        SupplyValidationException exception = assertThrows(SupplyValidationException.class,
                () -> SupplyValidator.validateSupply(supply));

        assertEquals(ErrorMessagesConstants.SUPPLY_VALIDATION_FAILED_ERROR_MESSAGE,
                exception.getMessage());

        assertEquals(expectedErros, exception.getErrors());

    }

}