package ru.tronin.shop.repositories.ProductCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tronin.shop.models.Product;
import ru.tronin.shop.repositories.ProductsRepository;

@Component
public class UpdateProductCommand implements ProductCommand{

    @Autowired
    ProductsRepository repository;

    @Override
    public void execute(Product product) {

        if (product.getId() != null){
            repository.save(product);
        }
    }
}
