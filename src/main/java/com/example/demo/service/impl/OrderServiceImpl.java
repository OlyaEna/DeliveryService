package com.example.demo.service.impl;

import com.example.demo.dto.OrderDto;
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


    public OrderDto createOrderFromItems(User user, List<OrderItem> orderItems, String name, String address, double cost) {
        Order order = new Order();
        order.setOrderItems(new ArrayList<>());
        order.setUser(user);
        order.setName(name);
        order.setAddress(address);
        order.setCost(cost);
        orderItems.stream().forEach(orderItem -> {
            order.getOrderItems().add(orderItem);
            orderItem.setOrder(order);
        })
        ;
        orderItems.clear();
        orderRepository.save(order);
        OrderDto orderDto = new OrderDto();
        mapper(orderDto, order);
        return orderDto;
    }

    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.getReferenceById(id);
        OrderDto orderDto = new OrderDto();
        mapper(orderDto, order);
        return orderDto;
    }

    private void mapper(OrderDto orderDto, Order order) {
        orderDto.setId(order.getId());
        orderDto.setUser(order.getUser());
        orderDto.setOrderItems(order.getOrderItems());
        orderDto.setName(order.getName());
        orderDto.setAddress(order.getAddress());
        orderDto.setOrder_date(order.getOrder_date());
        orderDto.setCost(order.getCost());
    }

    public List<OrderDto> getOrderByUser(User user) {
        List<Order> orders = orderRepository.findAllByUser(user);
        List<OrderDto> orderDtoList = transfer(orders);
        return orderDtoList;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtoList = transfer(orders);
        return orderDtoList;
    }

    private List<OrderDto> transfer(List<Order> orders) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            mapper(orderDto, order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }


    public List<OrderDto> getCustomOrders(Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        return getOrderByUser(user);
    }

}
