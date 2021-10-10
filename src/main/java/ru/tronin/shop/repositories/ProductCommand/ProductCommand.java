package ru.tronin.shop.repositories.ProductCommand;

import org.springframework.stereotype.Component;
import ru.tronin.shop.models.Product;
@Component
public interface ProductCommand {
    void execute(Product product);
}
