package com.example.demo.service;

import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.User;

import java.security.Principal;
import java.util.List;

public interface OrderService {

    Order createOrderFromItems(User user, List<OrderItem> orderItems, String name, String address, double cost);

    Order getOrderById(Long id);

    List<Order> getOrderByUser(User user);

    List<Order> getAllOrders();

    List<Order> getCustomOrders(Principal principal);

}
