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
public abstract class AbstractProductDto {
    Long id;

    public AbstractProductDto(Long id) {
        this.id = id;
    }
}
