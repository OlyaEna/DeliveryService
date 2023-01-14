package com.example.demo.service.impl;

import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.User;
import com.example.demo.model.repository.OrderRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;


    public Order createOrderFromItems(User user, List<OrderItem> orderItems, String name, String address, double cost) {
        Order order = new Order();
        order.setOrderItems(new ArrayList<>());
        order.setUser(user);
        order.setName(name);
        order.setAddress(address);
        order.setCost(cost);
        orderItems.stream().forEach(orderItem -> {
            order.getOrderItems().add(orderItem);
            orderItem.setOrder(order);
        });
        orderItems.clear();
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.getReferenceById(id);
    }

    public List<Order> getOrderByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    public List<Order> getCustomOrders(Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        return getOrderByUser(user);
    }

}
