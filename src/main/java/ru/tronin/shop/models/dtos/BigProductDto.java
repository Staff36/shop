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
public class BigProductDto extends DefaultProductDto {
    String description;

    public BigProductDto(Long id, String name, Double price, String description) {
        super(id, name, price);
        this.description = description;
    }
}
