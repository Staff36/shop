package ru.tronin.shop.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.tronin.shop.models.dtos.AbstractProductDto;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SmallProductDto extends AbstractProductDto {
    String name;

    public SmallProductDto(Long id, String name) {
        super(id);
        this.name = name;
    }
}
