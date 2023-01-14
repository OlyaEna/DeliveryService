package com.example.demo.service;


import com.example.demo.model.entity.OrderItem;

import java.util.List;

public interface PropertiesService {
    double getDeliveryPrice(double sumTotal);
    int getFreeCoffee(List<OrderItem> items);
}
