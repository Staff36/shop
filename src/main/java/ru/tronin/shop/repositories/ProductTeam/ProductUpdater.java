package ru.tronin.shop.repositories.ProductTeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.tronin.shop.models.Product;

@Component
public class ProductUpdater {
    @Autowired
    @Qualifier(value = "insertProductCommand")
    ProductCommand insert;
    @Autowired
    @Qualifier(value = "updateProductCommand")
    ProductCommand update;
    @Autowired
    @Qualifier(value = "removeProductCommand")
    ProductCommand remove;

    public void insertProduct(Product product){
        insert.execute(product);
    }

    public void updateProduct(Product product){
        update.execute(product);
    }

    public void removeProduct(Product product){

        remove.execute(product);
    }



}
