package ru.tronin.shop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @JoinColumn(name = "cart_id")
    @OneToOne(targetEntity = Cart.class)
    Cart cart;
    @JoinColumn(name = "user_id")
    @OneToOne(targetEntity = User.class)
    User user;

    @Column(name = "date")
    @CreationTimestamp
    LocalDateTime createdAt;
}
