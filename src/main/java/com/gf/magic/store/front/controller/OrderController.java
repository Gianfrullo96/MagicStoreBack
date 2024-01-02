package com.gf.magic.store.front.controller;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.model.Order;
import com.gf.magic.store.front.pojos.OrderStatus;
import com.gf.magic.store.front.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * Endpoint to add a new order for a userEntity.
     *
     * @param userId The ID of the userEntity placing the order.
     * @param cards  List of cards to be included in the order.
     * @return ResponseEntity indicating the success of the operation.
     */
    @PostMapping("/users/{userId}")
    public ResponseEntity<String> addOrder(@PathVariable Long userId, @RequestBody List<Card> cards) {
        orderService.addOrder(userId, cards);
        return new ResponseEntity<>("Order added successfully", HttpStatus.CREATED);
    }
    /**
     * Endpoint to update the status of an order.
     *
     * @param orderId   The ID of the order to update.
     * @param newStatus The new status to set for the order.
     * @return ResponseEntity indicating the success of the operation.
     */

    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatus newStatus) {
        orderService.updateOrderStatus(orderId, newStatus);
        return new ResponseEntity<>("Order status updated successfully", HttpStatus.OK);
    }
    /**
     * Endpoint to retrieve orders for a specific userEntity.
     *
     * @param userId The ID of the userEntity to retrieve orders for.
     * @return ResponseEntity containing the list of userEntity orders.
     */
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> userOrders = orderService.getUserOrders(userId);
        return new ResponseEntity<>(userOrders, HttpStatus.OK);
    }

    // Add other endpoints as needed
}
