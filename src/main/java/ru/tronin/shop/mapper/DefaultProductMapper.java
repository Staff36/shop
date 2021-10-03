package ru.tronin.shop.mapper;

import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.models.dtos.DefaultProductDto;
import ru.tronin.shop.models.dtos.SmallProductDto;

public class DefaultProductMapper extends ProductMapperDecorator{


    public DefaultProductMapper(Mapper<Product, AbstractProductDto> abstractProductDtoMapper) {
        super(abstractProductDtoMapper);
    }

    @Override
    public AbstractProductDto map(Product e) {
        SmallProductDto map = (SmallProductDto) super.map(e);
        return new DefaultProductDto(map.getId(), map.getName(), e.getPrice());

    }
}
