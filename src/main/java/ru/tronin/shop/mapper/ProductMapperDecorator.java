package ru.tronin.shop.mapper;

import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.models.dtos.SmallProductDto;

public class ProductMapperDecorator implements Mapper<Product, AbstractProductDto>{

    Mapper<Product, AbstractProductDto> abstractProductDtoMapper;

    public ProductMapperDecorator(Mapper<Product, AbstractProductDto> abstractProductDtoMapper) {
        this.abstractProductDtoMapper = abstractProductDtoMapper;
    }

    @Override
    public AbstractProductDto map(Product e) {
        return abstractProductDtoMapper.map(e);
    }
}
