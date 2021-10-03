package ru.tronin.shop.mapper;

import org.springframework.stereotype.Component;

@Component
public interface Mapper<T, E> {
    E map(T e);
}
