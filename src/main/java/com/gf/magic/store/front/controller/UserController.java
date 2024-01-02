package com.gf.magic.store.front.controller;

import com.gf.magic.store.front.model.Card;
import com.gf.magic.store.front.model.Order;
import com.gf.magic.store.front.model.UserEntity;
import com.gf.magic.store.front.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
@Slf4j
@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntities = userService.getAllUsers();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<String> findByUsername(@PathVariable String username) {
        UserEntity user = userService.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.createUser(userEntity);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(userEntity.getUsername()).toUriString());
        return ResponseEntity.created(uri).build();
    }



    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long userId) {

        UserEntity userEntity = userService.getUserById(userId);
        if (userEntity != null) {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    //TODO
    @PutMapping("/{userId}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long userId, @RequestBody UserEntity updatedUserEntity) {
        UserEntity updated = userService.updateUser(userId, updatedUserEntity);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/cart")
    public ResponseEntity<List<Card>> getUserCart(@PathVariable Long userId) {
        List<Card> cart = userService.getUserCart(userId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> orders = userService.getUserOrders(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/{userId}/cart/add")
    public ResponseEntity<String> addCardToUserCart(@PathVariable Long userId, @RequestBody Card card) {
        userService.addCardToUserCart(userId, card);
        return new ResponseEntity<>("Card added to cart successfully", HttpStatus.OK);
    }

    @PostMapping("/{userId}/cart/remove")
    public ResponseEntity<String> removeCardFromUserCart(@PathVariable Long userId, @RequestBody Card card) {
        userService.removeCardFromUserCart(userId, card);
        return new ResponseEntity<>("Card removed from cart successfully", HttpStatus.OK);
    }

}
