package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.datatest.SupplyDataTest;
import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessagesConstants;
import com.resourceserver.emazontransactionsservice.domain.exception.SupplyValidationException;
import com.resourceserver.emazontransactionsservice.domain.feign.StockFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.validations.SupplyValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddSupplyUseCaseTest {

    @Mock
    private SupplyPersistencePort supplyPersistencePort;

    @Mock
    private StockFeignPort stockFeignPort;

    @InjectMocks
    private AddSupplyUseCase supplyUseCase;

    @Test
    public void shouldAddSupplyAndSaveTransactionSuccessfully() {
        Supply supply = SupplyDataTest.createValidSupply();

        supplyUseCase.addSupplyAndSaveTransaction(supply);

        verify(stockFeignPort, times(1)).addSupply(supply);
        verify(supplyPersistencePort, times(1)).saveSupplyTransactions(supply);
    }

    @Test
    public void shouldThrowExceptionWhenSupplyValidationFails() {
        Supply supply = SupplyDataTest.createInvalidSupply();
        List<String> expectedErros = List.of(
                ErrorMessagesConstants.ARTICLE_ID_MUST_BE_GREATER_THAN_ZERO,
                ErrorMessagesConstants.NAME_MUST_NOT_BE_NULL_OR_EMPTY,
                ErrorMessagesConstants.QUANTITY_MUST_BE_GREATER_THAN_ZERO
        );

        SupplyValidationException exception = assertThrows(SupplyValidationException.class, () -> {
            SupplyValidator.validateSupply(supply);
        });

        assertEquals(ErrorMessagesConstants.SUPPLY_VALIDATION_FAILED_ERROR_MESSAGE,
                exception.getMessage());

        assertEquals(expectedErros, exception.getErrors());

        }


}