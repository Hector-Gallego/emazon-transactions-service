package com.resourceserver.emazontransactionsservice.ports.driven.feign.adapters;

import com.resourceserver.emazontransactionsservice.domain.exception.*;
import com.resourceserver.emazontransactionsservice.domain.feign.PurchaseTransactionOrchestrationFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.CartItem;
import com.resourceserver.emazontransactionsservice.domain.model.SaleData;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.ReportServiceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.ShoppingCartMicroserviceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.StockMicroServiceFeignClient;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class PurchaseTransactionOrchestratorAdapter implements PurchaseTransactionOrchestrationFeignPort {

    private final ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient;
    private final StockMicroServiceFeignClient stockMicroServiceFeignClient;
    private final ReportServiceFeignClient reportServiceFeignClient;

    public PurchaseTransactionOrchestratorAdapter(ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient,
                                                  StockMicroServiceFeignClient stockMicroServiceFeignClient,
                                                  ReportServiceFeignClient reportServiceFeignClient) {
        this.shoppingCartMicroserviceFeignClient = shoppingCartMicroserviceFeignClient;
        this.stockMicroServiceFeignClient = stockMicroServiceFeignClient;
        this.reportServiceFeignClient = reportServiceFeignClient;
    }

    @Override
    public void orchestratePurchaseTransaction() {
        List<CartItem> cartItems = fetchCartItems();
        SaleData saleData = updateStock(cartItems);
        clearCart(cartItems);
        saveReport(saleData, cartItems);
    }

    private List<CartItem> fetchCartItems() {
        try {
            ResponseEntity<List<CartItem>> response = shoppingCartMicroserviceFeignClient.getAllItemsShoppingCart();
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new GetItemsCartException("Error al obtener los items del carrito");
            }
            return response.getBody();
        } catch (Exception e) {
            throw new PurchaseOrchestratorException("Error al obtener los items del carrito");
        }
    }

    private SaleData updateStock(List<CartItem> cartItems) {
        try {
            ResponseEntity<SaleData> response = stockMicroServiceFeignClient.updateStockAndGetSaleData(cartItems);
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new StockUpdateException("Error al actualizar el stock");
            }
            return response.getBody();
        } catch (Exception e) {
            throw new PurchaseOrchestratorException("Error al actualizar el stock");
        }
    }

    private void clearCart(List<CartItem> cartItems) {
        try {
            ResponseEntity<Void> response = shoppingCartMicroserviceFeignClient.clearCart();
            if (!response.getStatusCode().is2xxSuccessful()) {
                updateStockCompensation(cartItems);
                throw new CartClearException("Error al limpiar el carrito");
            }
        } catch (Exception e) {
            updateStockCompensation(cartItems);
            throw new PurchaseOrchestratorException("Error al limpiar el carrito");
        }
    }

    private void saveReport(SaleData saleData, List<CartItem> cartItems) {
        try {
            ResponseEntity<Long> response = reportServiceFeignClient.saveReport(saleData);
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new SavePurchaseReportException("Error al guardar el reporte de compra");
            }
        } catch (Exception e) {
            updateStockCompensation(cartItems);
            addItemsShoppingCartCompensation(cartItems);
            throw new PurchaseOrchestratorException("Error al guardar el reporte de compra");
        }
    }

    private void updateStockCompensation(List<CartItem> cartItems) {
        try {
            stockMicroServiceFeignClient.updateStockCompensation(cartItems);
        } catch (Exception e) {
            throw new PurchaseOrchestratorException("Error al compensar el stock");
        }
    }

    private void addItemsShoppingCartCompensation(List<CartItem> cartItems) {
        try {
            shoppingCartMicroserviceFeignClient.addItemsCart(cartItems);
        } catch (Exception e) {
            throw new PurchaseOrchestratorException("Error al añadir items al carrito durante la compensación");
        }
    }
}




/*
public class PurchaseTransactionOrchestratorAdapter implements PurchaseTransactionOrchestrationFeignPort {

    private final ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient;
    private final StockMicroServiceFeignClient stockMicroServiceFeignClient;
    private final ReportServiceFeignClient reportServiceFeignClient;

    public PurchaseTransactionOrchestratorAdapter(ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient, StockMicroServiceFeignClient stockMicroServiceFeignClient, ReportServiceFeignClient reportServiceFeignClient) {
        this.shoppingCartMicroserviceFeignClient = shoppingCartMicroserviceFeignClient;
        this.stockMicroServiceFeignClient = stockMicroServiceFeignClient;
        this.reportServiceFeignClient = reportServiceFeignClient;
    }

    @Override
    public void orchestratePurchaseTransaction() {

        //obtener los item del carrito de usuario
        List<CartItem> cartItems = new ArrayList<>();
        try {

            //ir a carrito y obtener los items del carrito del usuario
            ResponseEntity<List<CartItem>> response = shoppingCartMicroserviceFeignClient.getAllItemsShoppingCart();
            cartItems = response.getBody();
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new GetItemsCartException("error al obtener los items del carrito");
            }

            // ir a stock y descontar la cantidad de items
            ResponseEntity<SaleData> responseSaleData = stockMicroServiceFeignClient.updateStockAndGetSaleData(cartItems);
            if (!responseSaleData.getStatusCode().is2xxSuccessful()) {
                throw new StockUpdateException("error al actualizar el stock");
            }

            //ir a carrito y eliminar el carrito
            ResponseEntity<Void> responseClearCart = shoppingCartMicroserviceFeignClient.clearCart();
            if (!responseClearCart.getStatusCode().is2xxSuccessful()) {
                throw new CartClearException("error al limpiar el carrito");
            }

            // ir a reporte y generar el reporte
            SaleData saleData = responseSaleData.getBody();
            ResponseEntity<Long> responseReport = reportServiceFeignClient.saveReport(saleData);
            if (!responseReport.getStatusCode().is2xxSuccessful()) {
                throw new SavePurchaseReportException("error al guardar el registro de compra");
            }

        } catch (GetItemsCartException  e) {

            throw new PurchaseOrchestratorException("error al obtener los items del carrito");

        } catch ( StockUpdateException e) {

            throw new PurchaseOrchestratorException("error al actualizar el stock");

        } catch (CartClearException e) {

            updateStockCompensation(cartItems);
            throw new PurchaseOrchestratorException("error al limpiar el carrito");

        } catch (SavePurchaseReportException e) {

            updateStockCompensation(cartItems);
            addItemsShoppingCartCompensation(cartItems);
            throw new PurchaseOrchestratorException("error al guardar el registro de compra");

        }

    }

    private void updateStockCompensation(List<CartItem> cartItems) {
        stockMicroServiceFeignClient.updateStockCompensation(cartItems);
    }

    private void addItemsShoppingCartCompensation(List<CartItem> cartItems) {
        shoppingCartMicroserviceFeignClient.addItemsCart(cartItems);
    }


}
*/