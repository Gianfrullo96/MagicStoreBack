package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.model.Order;
import com.gf.magic.store.front.pojos.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
@Service
public interface OrderService {
    void addOrder(Long userId, List<Card> cards);

    void updateOrderStatus(Long orderId, OrderStatus newStatus);

    List<Order> getUserOrders(Long userId);
}
