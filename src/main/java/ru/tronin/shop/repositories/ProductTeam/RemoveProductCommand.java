package ru.tronin.shop.repositories.ProductTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tronin.shop.models.Product;
import ru.tronin.shop.repositories.ProductsRepository;

@Component
public class RemoveProductCommand implements ProductCommand{

    @Autowired
    ProductsRepository repository;

    @Override
    public void execute(Product product) {
        repository.delete(product);
    }
}
