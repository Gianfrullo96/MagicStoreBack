package com.gf.magic.store.front.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

/**
 * @author gferruzzi@konvergence.local
 * @version 1.0
 * @since 8/31/23
 */
@Jacksonized
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
@JsonIgnoreProperties("orders")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;


    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @ManyToMany
    @JoinTable(
            name = "user_cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cart;

    @ConstructorProperties({"username", "email", "password", "roles", "orders", "cart"})
    public UserEntity(String username, String email, String password,
                      Collection<Role> roles, List<Order> orders, List<Card> cart) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.orders = orders;
        this.cart = cart;
    }

    // Getters and setters
    // Constructors
}
