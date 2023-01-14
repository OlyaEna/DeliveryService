package com.example.demo.service;

import com.example.demo.dto.TypeDto;
import com.example.demo.model.entity.Type;

import java.util.List;
import java.util.Optional;

public interface TypeService {

    List<TypeDto> showAllAvailable ();

    Optional<Type> get(Long id);
}
