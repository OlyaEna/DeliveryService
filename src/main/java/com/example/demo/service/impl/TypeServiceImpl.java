package com.example.demo.service.impl;

import com.example.demo.dto.TypeDto;
import com.example.demo.model.entity.Type;
import com.example.demo.model.repository.TypeRepository;
import com.example.demo.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public List<TypeDto> showAllAvailable() {
        List<Type> types = typeRepository.showAll();
        List<TypeDto> typeDtoList = mapper(types);
        return typeDtoList;
    }

    private List<TypeDto> mapper(List<Type> types) {
        List<TypeDto> typeDtoList = new ArrayList<>();
        for (Type type : types) {
            TypeDto typeDto = new TypeDto();
            typeDto.setId(type.getId());
            typeDto.setName(type.getName());
            typeDto.setPrice(type.getPrice());
//            typeDto.setDisabled(type.getDisabled());
            typeDtoList.add(typeDto);
        }
        return typeDtoList;
    }

    @Override
    public Optional<Type> get(Long id) {
        return typeRepository.findById(id);
    }
}
