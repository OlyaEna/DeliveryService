package com.example.demo.service;

import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.Type;
import com.example.demo.model.repository.PropertiesRepository;
import com.example.demo.service.impl.PropertiesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PropertiesServiceImplTest {
    @Mock
    private PropertiesRepository propertiesRepository;
    @InjectMocks
    private PropertiesServiceImpl propertiesService;

    private Type type1 = new Type(1L, "Latte", "Латте", 10, 'N');
    private Type type2 = new Type(2L, "Americano", "Американо", 5, 'N');
    private Type type3 = new Type(3L, "Espresso", "Эспрессо", 5, 'N');


    private OrderItem orderItem1=new OrderItem(type1, 1);
    private OrderItem orderItem2=new OrderItem(type2, 1);
    private OrderItem orderItem3=new OrderItem(type3, 9);



    @Test
    public void calcDeliveryTest() {
        double deliveryCost = 20;
        double freeDeliveryLevel = 100;

        when(propertiesRepository.deliveryPrice()).thenReturn(deliveryCost);
        when(propertiesRepository.sumForFreeDelivery()).thenReturn(freeDeliveryLevel);

        double result = propertiesService.getDeliveryPrice(89);
        assertEquals(deliveryCost, result);

        result = propertiesService.getDeliveryPrice(freeDeliveryLevel);
        assertEquals(0, result);
    }

    @Test
    public void getFreeCupTest() {
        int freeCup = 4;
        List<OrderItem> items = new ArrayList<>(Arrays.asList(orderItem1, orderItem2));

        when(propertiesRepository.freeCoffeeCup()).thenReturn(freeCup);
        int result = propertiesService.getFreeCoffee(items);
        assertEquals(0, result);

        items.add(orderItem3);
        result = propertiesService.getFreeCoffee(items);
        assertEquals(-10, result);
    }
}
