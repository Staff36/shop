package ru.tronin.shop.mapper;

import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.models.dtos.BigProductDto;
import ru.tronin.shop.models.dtos.DefaultProductDto;

public class BigProductDtoMapper extends ProductMapperDecorator{


    public BigProductDtoMapper(Mapper<Product, AbstractProductDto> mapper) {
        super(mapper);
    }

    @Override
    public AbstractProductDto map(Product e) {
        DefaultProductDto productDto = (DefaultProductDto) super.map(e);
        return new BigProductDto(productDto.getId(), productDto.getName(), productDto.getPrice(), e.getDescription());
    }
}
