package com.example.demo.controllers;

import com.example.demo.dto.TypeDto;
import com.example.demo.model.repository.PropertiesRepository;
import com.example.demo.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;
    private final PropertiesRepository propertiesRepository;

    @GetMapping("/")
    public String types(Model model) {
        List<TypeDto> typeDto = typeService.showAllAvailable();
        model.addAttribute("typeDto", typeDto);
        model.addAttribute("size", typeDto.size());
        model.addAttribute("freeCup", propertiesRepository.freeCoffeeCup());
        model.addAttribute("freeDelivery", propertiesRepository.sumForFreeDelivery());
        model.addAttribute("delivery", propertiesRepository.deliveryPrice());
        return "types";
    }

    @GetMapping("/ru")
    public String typesRu(Model model) {
        List<TypeDto> typeDto = typeService.showAllAvailable();
        model.addAttribute("typeDto", typeDto);
        model.addAttribute("size", typeDto.size());
        model.addAttribute("freeCup", propertiesRepository.freeCoffeeCup());
        model.addAttribute("freeDelivery", propertiesRepository.sumForFreeDelivery());
        model.addAttribute("delivery", propertiesRepository.deliveryPrice());
        return "ru/types-ru";
    }


}
