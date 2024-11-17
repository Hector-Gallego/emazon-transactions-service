package com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces;

import com.resourceserver.emazontransactionsservice.domain.model.CartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "shopping-cart-service",
        url = "http://localhost:9020")
public interface ShoppingCartMicroserviceFeignClient {
    @GetMapping("/api/cart/getAllItemsShoppingCart")
    ResponseEntity<List<CartItem>> getAllItemsShoppingCart();


    @DeleteMapping("api/cart/clearCart")
    ResponseEntity<Void> clearCart();

    @PostMapping("api/cart/addItemsCart")
    ResponseEntity<Void> addItemsCart(@RequestBody List<CartItem> cartItems);
}
