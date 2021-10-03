package ru.tronin.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tronin.shop.mapper.BigProductDtoMapper;
import ru.tronin.shop.mapper.DefaultProductMapper;
import ru.tronin.shop.mapper.ProductMapperDecorator;
import ru.tronin.shop.mapper.SmallProductDtoMapper;
import ru.tronin.shop.models.Product;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.repositories.ProductsRepository;


@Component
public class ProductService {

    @Autowired
    private ProductsRepository repository;


    public AbstractProductDto getProductById(Long id, String typeDto) {
        Product product = repository.getById(id);
        return mapProductToDto(product, typeDto);
    }


    private AbstractProductDto mapProductToDto(Product product, String type) {
        ProductMapperDecorator decorator;
        switch (type) {
            case "small":
                decorator = new ProductMapperDecorator(new SmallProductDtoMapper());
                break;
            case "big":
                decorator = new ProductMapperDecorator(new BigProductDtoMapper(new DefaultProductMapper(new SmallProductDtoMapper())));
                break;
            default:
                decorator = new ProductMapperDecorator(new DefaultProductMapper(new SmallProductDtoMapper()));
        }
        return decorator.map(product);
    }


}
