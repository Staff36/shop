package ru.tronin.shop.mapper.ProductMapper;

import ru.tronin.shop.mapper.Mapper;
import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.models.dtos.BigProductDto;
import ru.tronin.shop.models.dtos.DefaultProductDto;

public class BigProductDtoMapper extends ProductMapperDecorator{


    public BigProductDtoMapper(Mapper<Product, AbstractProductDto> mapper) {
        super(mapper);
    }

    @Override
    public AbstractProductDto mapEntityToDto(Product product) {
        DefaultProductDto productDto = (DefaultProductDto) super.mapEntityToDto(product);
        return new BigProductDto(productDto.getId(), productDto.getName(), productDto.getPrice(), product.getDescription());
    }

    @Override
    public Product mapDtoToEntity(AbstractProductDto productDto) {
        Product product = super.mapDtoToEntity(productDto);
        if (productDto instanceof BigProductDto){
            product.setDescription(((BigProductDto)productDto).getDescription());
        }
        return product;
    }
}
