package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    @NotEmpty(message = "Address should not be empty")
    private String address;
    @Size(min = 4, max = 20, message = "Name should have 5-20 characters")
    private String name;

}
