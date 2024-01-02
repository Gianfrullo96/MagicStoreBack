package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.model.Order;
import com.gf.magic.store.front.model.UserEntity;

import java.util.List;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 1/2/24
 */
public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity findByUsername(String username);

    UserEntity createUser(UserEntity userEntity);

    UserEntity getUserById(Long userId);

    UserEntity updateUser(Long userId, UserEntity updatedUserEntity);

    void deleteUser(Long userId);

    List<Card> getUserCart(Long userId);

    List<Order> getUserOrders(Long userId);

    void addCardToUserCart(Long userId, Card card);

    void removeCardFromUserCart(Long userId, Card card);
}
