package ru.tronin.shop.mapper.ProductMapper;

import ru.tronin.shop.mapper.Mapper;
import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;

public class ProductMapperDecorator implements Mapper<Product, AbstractProductDto> {

    Mapper<Product, AbstractProductDto> abstractProductDtoMapper;

    public ProductMapperDecorator(Mapper<Product, AbstractProductDto> abstractProductDtoMapper) {
        this.abstractProductDtoMapper = abstractProductDtoMapper;
    }

    @Override
    public AbstractProductDto mapEntityToDto(Product product) {
        return abstractProductDtoMapper.mapEntityToDto(product);
    }

    @Override
    public Product mapDtoToEntity(AbstractProductDto productDto) {
        return abstractProductDtoMapper.mapDtoToEntity(productDto);
    }
}
