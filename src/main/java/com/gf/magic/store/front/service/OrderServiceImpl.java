package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.model.Order;
import com.gf.magic.store.front.model.UserEntity;
import com.gf.magic.store.front.pojos.OrderStatus;
import com.gf.magic.store.front.repository.CardRepo;
import com.gf.magic.store.front.repository.OrderRepo;
import com.gf.magic.store.front.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */

@Service
public class OrderServiceImpl implements OrderService{


    @Autowired
    OrderRepo orderRepository;

    @Autowired
    CardRepo cardRepository;

    @Autowired
    UserRepo userRepository;
    @Override
    public void addOrder(Long userId, List<Card> cards) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        if (userEntity == null) {
            throw new EntityNotFoundException("UserEntity with ID " + userId + " not found.");
        }
        List<Card> findedCard = new ArrayList<>();
        for (Card card: cards ) {

            card = cardRepository.getCardByName(card.getName());
            System.out.println(card.toString());
            findedCard.add(card);
        }

        if (cards == null || cards.isEmpty()) {
            throw new IllegalArgumentException("Card list cannot be null or empty.");
        }
        if (userEntity != null && cards != null && !cards.isEmpty()) {
            Order order = new Order();
            order.setUser(userEntity);
            order.setCards(findedCard);
            double totalPrice = calculateTotalPrice(cards);
            order.setTotalPrice(totalPrice);
            order.setOrderDate(new Date());
            order.setOrderStatus(OrderStatus.PENDING);

            // Update card quantities, remove cards from userEntity's cart, etc.

            orderRepository.save(order);

            // You might also want to update userEntity's order list, cart, etc.

            userRepository.save(userEntity);
        }
    }
    @Override
    public void updateOrderStatus(Long orderId,OrderStatus newStatus) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            throw new EntityNotFoundException("Order with ID " + orderId + " not found.");
        }

        order.setOrderStatus(newStatus);
        orderRepository.save(order);
    }

    private double calculateTotalPrice(List<Card> cards) {
        double totalPrice= 0;
        for (Card card : cards) {
            totalPrice += card.getPrice();
        }
        return totalPrice;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        if (userEntity != null) {
            return userEntity.getOrders();
        }
        return Collections.emptyList();
    }

}
