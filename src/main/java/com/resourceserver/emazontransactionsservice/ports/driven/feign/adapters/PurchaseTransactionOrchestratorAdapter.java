package com.resourceserver.emazontransactionsservice.ports.driven.feign.adapters;

import com.resourceserver.emazontransactionsservice.domain.api.SaleServicePort;
import com.resourceserver.emazontransactionsservice.domain.constants.ErrorMessageConstants;
import com.resourceserver.emazontransactionsservice.domain.exception.*;
import com.resourceserver.emazontransactionsservice.domain.feign.PurchaseTransactionOrchestrationFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.CartItem;
import com.resourceserver.emazontransactionsservice.domain.model.PurchaseReport;
import com.resourceserver.emazontransactionsservice.domain.model.SaleReport;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.ReportServiceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.ShoppingCartMicroserviceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.StockMicroServiceFeignClient;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseTransactionOrchestratorAdapter implements PurchaseTransactionOrchestrationFeignPort {

    private final ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient;
    private final StockMicroServiceFeignClient stockMicroServiceFeignClient;
    private final ReportServiceFeignClient reportServiceFeignClient;
    private final SaleServicePort saleServicePort;
    private final AuthenticatedManagerPort authenticatedManagerPort;

    public PurchaseTransactionOrchestratorAdapter(ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient,
                                                  StockMicroServiceFeignClient stockMicroServiceFeignClient,
                                                  ReportServiceFeignClient reportServiceFeignClient, SaleServicePort saleServicePort, AuthenticatedManagerPort authenticatedManagerPort) {
        this.shoppingCartMicroserviceFeignClient = shoppingCartMicroserviceFeignClient;
        this.stockMicroServiceFeignClient = stockMicroServiceFeignClient;
        this.reportServiceFeignClient = reportServiceFeignClient;
        this.saleServicePort = saleServicePort;
        this.authenticatedManagerPort = authenticatedManagerPort;
    }

    @Override
    public void orchestratePurchaseTransaction() {
        List<CartItem> cartItems = fetchCartItems();
        PurchaseReport purchaseReport = updateStock(cartItems);
        clearCart(cartItems);
        saveReport(purchaseReport, cartItems);
    }

    private List<CartItem> fetchCartItems() {
        try {
            ResponseEntity<List<CartItem>> response = shoppingCartMicroserviceFeignClient.getAllItemsShoppingCart();
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new GetItemsCartException(ErrorMessageConstants.FETCH_CART_ITEMS_ERROR);
            }
            return response.getBody();
        } catch (Exception e) {
            throw new PurchaseOrchestratorException(ErrorMessageConstants.FETCH_CART_ITEMS_ERROR);
        }
    }

    private PurchaseReport updateStock(List<CartItem> cartItems) {
        try {
            ResponseEntity<PurchaseReport> response = stockMicroServiceFeignClient.updateStockAndGetSaleData(cartItems);
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new StockUpdateException(ErrorMessageConstants.STOCK_UPDATE_ERROR);
            }
            return response.getBody();
        } catch (Exception e) {
            throw new PurchaseOrchestratorException(ErrorMessageConstants.UPDATE_STOCK_ERROR);
        }
    }

    private void clearCart(List<CartItem> cartItems) {
        try {
            ResponseEntity<Void> response = shoppingCartMicroserviceFeignClient.clearCart();
            if (!response.getStatusCode().is2xxSuccessful()) {
                updateStockCompensation(cartItems);
                throw new CartClearException(ErrorMessageConstants.CLEAR_CART_ERROR);
            }
        } catch (Exception e) {
            updateStockCompensation(cartItems);
            throw new PurchaseOrchestratorException(ErrorMessageConstants.CLEAR_CART_ERROR);
        }
    }

    private void saveReport(PurchaseReport purchaseReport, List<CartItem> cartItems) {
        try {

            ResponseEntity<String> response = reportServiceFeignClient.saveReport(purchaseReport);
            saleServicePort.saveSaleTransactionReport(generateSaleReport(cartItems));

            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new SavePurchaseReportException(ErrorMessageConstants.SAVE_REPORT_ERROR);
            }
        } catch (Exception e) {
            updateStockCompensation(cartItems);
            addItemsShoppingCartCompensation(cartItems);
            throw new PurchaseOrchestratorException(ErrorMessageConstants.SAVE_REPORT_ERROR);
        }
    }

    private void updateStockCompensation(List<CartItem> cartItems) {
        try {
            stockMicroServiceFeignClient.updateStockCompensation(cartItems);
        } catch (Exception e) {
            throw new PurchaseOrchestratorException(ErrorMessageConstants.STOCK_COMPENSATION_ERROR);
        }
    }

    private void addItemsShoppingCartCompensation(List<CartItem> cartItems) {
        try {
            shoppingCartMicroserviceFeignClient.addItemsCart(cartItems);
        } catch (Exception e) {
            throw new PurchaseOrchestratorException(ErrorMessageConstants.ADD_ITEMS_COMPENSATION_ERROR);
        }
    }

    private SaleReport generateSaleReport(List<CartItem> cartItems){
        SaleReport saleReport = new SaleReport();
        saleReport.setCartItemList(cartItems);
        saleReport.setUserId(authenticatedManagerPort.getUserId());
        saleReport.setSaleDate(LocalDateTime.now());
        saleServicePort.saveSaleTransactionReport(saleReport);
        return  saleReport;
    }
}
