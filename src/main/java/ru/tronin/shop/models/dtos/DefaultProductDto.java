package ru.tronin.shop.models.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DefaultProductDto extends SmallProductDto {
   Double price;

    public DefaultProductDto(Long id, String name, Double price) {
        super(id, name);
        this.price = price;
    }
}
