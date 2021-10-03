package ru.tronin.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tronin.shop.models.Product;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

}
