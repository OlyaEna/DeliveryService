package com.example.demo.controllers;

import com.example.demo.dto.OrderDto;
import com.example.demo.model.entity.Order;
import com.example.demo.model.entity.OrderItem;
import com.example.demo.model.entity.Type;
import com.example.demo.model.entity.User;
import com.example.demo.service.PropertiesService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TypeService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Scope("session")
public class CartController {
    private final TypeService typeService;
    private final OrderService orderService;
    private final UserService userService;
    private final PropertiesService configurationService;
    List<OrderItem> orderItems = new ArrayList<>();
    Order order = new Order();
    double deliveryCost;

    @PostMapping("/cart")
    public String addCart(@RequestParam Long id, @RequestParam int quantity, HttpServletRequest request) {

        OrderItem orderItem = new OrderItem();
        Type type = new Type();
        double sumTotal = 0;

        Optional<Type> optionalType = typeService.get(id);
        type = optionalType.get();


        orderItem.setTotalPrice(type.getPrice() * quantity);

        orderItem.setQuantity(quantity);
        orderItem.setType(type);

        Long idType = type.getId();
        boolean added = orderItems.stream().anyMatch(p -> p.getType().getId() == idType);


        if (!added) {
            orderItems.add(orderItem);
        }

        sumTotal = orderItems.stream().mapToDouble(dt -> dt.getTotalPrice()).sum();
        deliveryCost = configurationService.getDeliveryPrice(sumTotal);
        double discount = configurationService.getFreeCoffee(orderItems);
        order.setCost(sumTotal + deliveryCost + discount);
        return getPreviousPageByRequest(request).orElse("/");
    }


    protected Optional<String> getPreviousPageByRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }


    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", orderItems);
        model.addAttribute("order", order);
        model.addAttribute("size", orderItems.size());
        model.addAttribute("deliveryCost", deliveryCost);
        return "user/cart";
    }


    @GetMapping("/order")
    public String getOrderPage(Model model) {
        model.addAttribute("order", order);
        return "user/order";
    }

    @PostMapping("/order")
    public String createOrder(@Valid OrderDto orderFromItems, BindingResult bindingResult,
                              Principal principal, @RequestParam("name") String name,
                              @RequestParam("address") String address) {
        if (bindingResult.hasErrors()) {
            return "user/order";
        }
        User user = userService.findUserByEmail(principal.getName());
        orderFromItems = orderService.createOrderFromItems(user, orderItems, name, address, order.getCost());
        return "redirect:/";
    }


    @GetMapping("/user/orders")
    public String showMyOrders(Model model, Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("orders", orderService.getCustomOrders(principal));
        return "user/orders";
    }


    @GetMapping("/order-details/{id}")
    public String getOrderDetails(Model model, @PathVariable("id") Long id) {
        OrderDto selectedOrder = orderService.getOrderById(id);
        model.addAttribute("selectedOrder", selectedOrder);
        return "user/order-details";
    }


}