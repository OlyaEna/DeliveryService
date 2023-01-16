package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.User;

import java.security.Principal;
import java.util.List;

public interface OrderService {

    OrderDto createOrderFromItems(User user, List<OrderItem> orderItems, String name, String address, double cost);

    OrderDto getOrderById(Long id);

    List<OrderDto> getOrderByUser(User user);

    List<OrderDto> getAllOrders();

    List<OrderDto> getCustomOrders(Principal principal);

}
