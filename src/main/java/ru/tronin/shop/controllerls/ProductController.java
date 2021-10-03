package ru.tronin.shop.controllerls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tronin.shop.models.dtos.AbstractProductDto;
import ru.tronin.shop.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public AbstractProductDto getProductById(@PathVariable Long id, @RequestParam(name = "type", required = false, defaultValue = "default") String type){
        return productService.getProductById(id, type);
    }
}
