package ru.tronin.shop.mapper.ProductMapper;

import ru.tronin.shop.mapper.Mapper;
import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.models.dtos.SmallProductDto;

public class SmallProductDtoMapper implements Mapper<Product, AbstractProductDto> {

    @Override
    public AbstractProductDto mapEntityToDto(Product e) {
        return new SmallProductDto(e.getId(), e.getName());
    }

    @Override
    public Product mapDtoToEntity(AbstractProductDto e) {
        Product product = new Product();
        product.setId(e.getId());
        if (e instanceof SmallProductDto){
            product.setName(((SmallProductDto) e).getName());
        }
        return product;
    }


}
