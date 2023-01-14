package com.example.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CoffeeOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime order_date;
    @Column(name = "customer_name",length = 100)

    @NotEmpty(message = "Not null")
    @Size(min = 3, max = 50, message = "min size 3 symbols and max size 50 symbols")
    private String name;
    @Column(name = "delivery_address", length = 200)
    @NotEmpty(message = "Not null")
    @Size(min = 3, max = 50, message = "min size 3 symbols and max size 50 symbols")
    private String address;
    private double cost;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany( mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;
}
