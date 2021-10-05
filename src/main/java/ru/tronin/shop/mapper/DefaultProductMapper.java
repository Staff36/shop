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
    public AbstractProductDto mapEntityToDto(Product product) {
        SmallProductDto map = (SmallProductDto) super.mapEntityToDto(product);
        return new DefaultProductDto(map.getId(), map.getName(), product.getPrice());

    }

    @Override
    public Product mapDtoToEntity(AbstractProductDto productDto) {
        Product product =  super.mapDtoToEntity(productDto);
        if (productDto instanceof DefaultProductDto){
            product.setPrice(((DefaultProductDto)productDto).getPrice());
        }
        return product;
    }
}
