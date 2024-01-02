package com.gf.magic.store.front.service;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.model.Order;
import com.gf.magic.store.front.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gianluca Ferruzzi
 * @version 1.0
 * @since 1/2/24
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return null;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity getUserById(Long userId) {
        return null;
    }

    @Override
    public UserEntity updateUser(Long userId, UserEntity updatedUserEntity) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public List<Card> getUserCart(Long userId) {
        return null;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return null;
    }

    @Override
    public void addCardToUserCart(Long userId, Card card) {

    }

    @Override
    public void removeCardFromUserCart(Long userId, Card card) {

    }
}
