package com.example.demo.dto;

import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    @NotEmpty(message = "Address should not be empty")
    private String address;
    @Size(min = 4, max = 20, message = "Name should have 5-20 characters")
    private String name;
    private double cost;
    private LocalDateTime order_date;
    private User user;
    private List<OrderItem> orderItems;
}
