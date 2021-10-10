package ru.tronin.shop.controllerls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tronin.shop.models.User;
import ru.tronin.shop.services.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UsersService service;


    @PostMapping
    public void saveNewUser(@RequestBody User user){
        service.saveNewUser(user.getEmail(), user.getPassword());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return service.getUserById(id);
    }
}
