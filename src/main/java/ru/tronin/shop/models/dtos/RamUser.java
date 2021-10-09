package ru.tronin.shop.models.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.tronin.shop.models.User;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RamUser {
    User user;
    Date date;
    Long ttl;
}
