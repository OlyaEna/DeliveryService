package com.example.demo.service.impl;


import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.repository.PropertiesRepository;
import com.example.demo.service.PropertiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertiesServiceImpl implements PropertiesService {

    private final PropertiesRepository configurationRepository;

    private static final int FREE_DELIVERY = 0;

    @Override
    public double getDeliveryPrice(double sumTotal) {
        double price = configurationRepository.deliveryPrice();
        double sumForFreeDelivery = configurationRepository.sumForFreeDelivery();
        if (sumTotal >= sumForFreeDelivery) {
            return FREE_DELIVERY;
        } else {
            return price;
        }
    }

    @Override
    public int getFreeCoffee(List<OrderItem> items) {
        int discount = 0;
        int freeCoffeeCup = configurationRepository.freeCoffeeCup();

        if (freeCoffeeCup != 0) {
            for (OrderItem orderItem : items) {
                discount -= (orderItem.getQuantity() / freeCoffeeCup) * orderItem.getType().getPrice();
            }
        }
        return discount;
    }


}
