package com.example.demo.controllers;

import com.example.demo.dto.TypeDto;
import com.example.demo.service.TypeService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @GetMapping(value = {"/", "/?lang=ru"})
    public String types(Model model) {
        List<TypeDto> typeDto = typeService.showAllAvailable();
        model.addAttribute("typeDto", typeDto);
        model.addAttribute("size", typeDto.size());
        return "types";
    }


}
