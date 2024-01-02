package com.gf.magic.store.front.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gf.magic.store.front.pojos.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

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
@Table(name="orders")
@JsonIgnoreProperties("userEntity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_card",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cards;

    private double totalPrice;
    private Date orderDate;

    @Enumerated(EnumType.STRING) // Store enum as string in the database
    private OrderStatus orderStatus; // Enum field for order status



    // Getters and setters
    // Constructors
}
