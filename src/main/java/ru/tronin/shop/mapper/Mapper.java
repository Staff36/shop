package ru.tronin.shop.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<T, H> {
    H mapEntityToDto(T e);
    T mapDtoToEntity(H e);
}
