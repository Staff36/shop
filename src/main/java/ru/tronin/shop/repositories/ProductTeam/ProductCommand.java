package ru.tronin.shop.repositories.ProductTeam;

import org.springframework.stereotype.Component;
import ru.tronin.shop.models.Product;
@Component
public interface ProductCommand {
    void execute(Product product);
}
