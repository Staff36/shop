package ru.tronin.shop.mapper;

import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.models.dtos.SmallProductDto;

public class SmallProductDtoMapper implements Mapper<Product, AbstractProductDto>{

    @Override
    public AbstractProductDto map(Product e) {
        return new SmallProductDto(e.getId(), e.getName());
    }
}
